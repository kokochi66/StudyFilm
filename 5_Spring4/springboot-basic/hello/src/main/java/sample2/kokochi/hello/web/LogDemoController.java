package sample2.kokochi.hello.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample2.kokochi.hello.MyLogger;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger mylogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest req) {
        String requestURL = req.getRequestURL().toString();
        mylogger.setRequestURL(requestURL);

        mylogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
