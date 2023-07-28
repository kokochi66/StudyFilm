package com.github.kokochi.link.developers.sdk.server.web;

import com.github.kokochi.link.developers.sdk.blockchain.api.ApiClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
public class HomeController {

    @Autowired
    private ApiClient apiClient;

    @GetMapping("/")
    public ModelAndView home(ModelAndView mav) {

        log.info("/ - 메인 페이지");
        mav.addObject("name","kokochi");
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/test")
    public ModelAndView test(ModelAndView mav) {
//        GenericResponse<WalletResponse> response = apiClient.wallet("tlink1dhtwpu3jnhtrna3caff544kswpql8dk28gfzqa");
//        GenericResponse<Collection<WalletResponse>> response = apiClient.wallets();
//        GenericResponse<Collection<TxResultResponse>> response = apiClient.transactionOfWallet("tlink1dhtwpu3jnhtrna3caff544kswpql8dk28gfzqa", System.currentTimeMillis(), null, null, null, null, null);
//        NonFungibleTokenMintRequest request = new NonFungibleTokenMintRequest();
//        request.setOwnerAddress("tlink1dhtwpu3jnhtrna3caff544kswpql8dk28gfzqa");
//        request.setOwnerSecret("JqqB1Jh47HFIBM7Yr8tinxSB6bQLdBBpmL44eqHvjkM=");
//        request.setName("weaponToken");
//        request.setToAddress("tlink1gqjznvpudy8pwzf6lknx6z4ykvxlpzx7el7qyf");
//        GenericResponse<TransactionResponse> response = apiClient.mintNonFungible("92e755ee", "10000002", request);
//        log.info("wallet response :: " + response.toString());

//        Utils utils = new Utils(null, null);
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("a", "a");
//        map.put("b","b");
//
//        List<Map<String,Object>> mList1 = new ArrayList<>();
//        Map<String, Object> mm1 = new HashMap<>();
//        mm1.put("mz","mz1");
//        mm1.put("ma","ma1");
//        mm1.put("mb","mb1");
//        mList1.add(mm1);
//
//        Map<String, Object> mm2 = new HashMap<>();
//        mm2.put("ma","ma2");
//        mm2.put("mb","mb2");
//        mm2.put("mc","mc2");
//        mList1.add(mm2);
//
//        Map<String, Object> mm3 = new HashMap<>();
//        mm3.put("ma","ma3");
//        mm3.put("mb","mb3");
//        mList1.add(mm3);
//
//        map.put("m", mList1);
//
//        String res = utils.mapToBodyString(map);
//        log.info("res :: " + res);
        log.info("/ - 메인 페이지");
        mav.setViewName("test");
        return mav;
    }



}
