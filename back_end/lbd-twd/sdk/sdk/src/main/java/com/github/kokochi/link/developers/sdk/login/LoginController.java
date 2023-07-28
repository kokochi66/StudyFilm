package com.github.kokochi.link.developers.sdk.login;

import com.github.kokochi.link.developers.sdk.blockchain.api.ApiClient;
import com.github.kokochi.link.developers.sdk.login.api.LoginApiClient;
import com.github.kokochi.link.developers.sdk.login.service.SessionUserDTO;
import com.github.kokochi.link.developers.sdk.server.properties.WalletProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/login")
@Log4j2
public class LoginController {

    @Autowired
    private ApiClient apiClient;

    @Autowired
    private LoginApiClient loginApiClient;

    @Autowired
    private WalletProperties walletProperties;

    @GetMapping("/testUser")
    public String testUserLoginGET(HttpServletRequest request, String user) {
        log.info("/login/testUser - 테스트계정 로그인 :: " + user);

        String walletAddress = "";
        if(user.equals("test1")) walletAddress = walletProperties.getTest1Address();
        if(user.equals("test2")) walletAddress = walletProperties.getTest2Address();
        if(user.equals("test3")) walletAddress = walletProperties.getTest3Address();
        HttpSession session = request.getSession();
        session.setAttribute("user", new SessionUserDTO(null, user, null, walletAddress));

        return "redirect:/game";
    }

    @GetMapping("/oauth2/code/line/redirect")
    public String loginSuccessGET(HttpServletRequest request ,String code, String state, String redirect) {
        log.info("/login/success - 로그인 성공 :: code = " + code +"/ state = "+ state+"/ redirect : "+redirect);

        Map<String, Object> accessToken = loginApiClient.issueAccessToken(code);
//        for (String s : accessToken.keySet()) {
//            log.info("issueResult :: " + s +" = " +accessToken.get(s));
//        }
        Map<String, Object> profile = loginApiClient.getUserProfile((String) accessToken.get("access_token"));
//        for (String s : profile.keySet()) {
//            log.info("profileResult :: " + s +" = " +profile.get(s));
//        }

        HttpSession session = request.getSession();
        session.setAttribute("user", new SessionUserDTO((String) profile.get("userId"),
                (String) profile.get("displayName"), (String) accessToken.get("access_token"), null));
        return "redirect:/game";
    }
}
