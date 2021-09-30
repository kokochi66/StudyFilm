package sample2.kokochi.hello.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample2.kokochi.hello.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;
    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}
