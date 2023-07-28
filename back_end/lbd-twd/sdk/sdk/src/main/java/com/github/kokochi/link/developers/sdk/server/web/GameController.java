package com.github.kokochi.link.developers.sdk.server.web;

import com.github.kokochi.link.developers.sdk.blockchain.api.ApiClient;
import com.github.kokochi.link.developers.sdk.blockchain.model.request.Request.*;
import com.github.kokochi.link.developers.sdk.blockchain.model.response.Response.*;
import com.github.kokochi.link.developers.sdk.login.service.SessionUserDTO;
import com.github.kokochi.link.developers.sdk.server.properties.WalletProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/game")
@Log4j2
public class GameController {

    @Autowired
    private ApiClient apiClient;

    @Autowired
    private WalletProperties walletProperties;

    @GetMapping("")
    public String gameGET(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null) {
            log.info("/game :: ERROR :: 로그인 되지 않음");
            return "redirect:/?errMsg=login";
        }
        SessionUserDTO user = (SessionUserDTO) session.getAttribute("user");

        log.info("user = " + user);

        return "game";
    }

    @GetMapping("/transfer/testCoin")
    @Transactional
    public String transferTestCoin(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null) {
            log.info("/game :: ERROR :: 로그인 되지 않음");
            return "redirect:/?errMsg=login";
        }
        SessionUserDTO user = (SessionUserDTO) session.getAttribute("user");
        log.info("user = " + user);

        TransferBaseCoinRequest request = new TransferBaseCoinRequest();
        request.setWalletSecret(walletProperties.getServiceSecret());
        request.setAmount("10000");
        if(user.getUserId() == null) request.setToAddress(user.getWalletAddress());
        if(user.getWalletAddress() == null) request.setToUserId(user.getUserId());

        GenericResponse<TransactionResponse> res = apiClient.transferBaseCoin(walletProperties.getServiceAddress(), request);
        log.info("basecoin result :: " + res);
        return "redirect:/game";
    }


    @GetMapping("/get/tran")
    public String getTransactionHistory(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null) {
            log.info("/game :: ERROR :: 로그인 되지 않음");
            return "redirect:/?errMsg=login";
        }
        SessionUserDTO user = (SessionUserDTO) session.getAttribute("user");
        log.info("user = " + user);

        TransferBaseCoinRequest request = new TransferBaseCoinRequest();
        request.setWalletSecret(walletProperties.getServiceSecret());
        request.setAmount("10000");
        if(user.getUserId() == null) request.setToAddress(user.getWalletAddress());
        if(user.getWalletAddress() == null) request.setToUserId(user.getUserId());

        GenericResponse<Collection<TxResultResponse>> res = apiClient.transactionOfUser(user.getUserId(), 50, null, OrderBy.DESC, null, null);
        for (Object txResultResponse : (List) res.getResponseData()) {
            LinkedHashMap<String, Object> hashMap = (LinkedHashMap<String, Object>) txResultResponse;
            List<LinkedHashMap> logs = (List<LinkedHashMap>) hashMap.get("logs");
            for (LinkedHashMap logMap : logs) {
                log.info("logs :: " + logMap.get("events").getClass().getSimpleName() +" "+logMap.get("events"));
            }
        }


        return "redirect:/game";
    }
}
