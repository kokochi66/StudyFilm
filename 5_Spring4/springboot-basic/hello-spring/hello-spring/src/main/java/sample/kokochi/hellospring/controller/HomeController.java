package sample.kokochi.hellospring.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class HomeController {

    @GetMapping
    public String home(Model model) {
        log.info("/home :: 홈 매핑");

        return "home";
    }

/*
    비즈니스 요구사항 정리
    데이터: 회원ID, 이름
    기능 : 회원 등록, 조회
    (아직 DB가 선정되지 않은 상황임 -> interface를 구현하고, 실제 구현을 별도로 구현하여 향후에 수정이 쉽게한다.)
    개발 진행을 위해서 초기 개발단계의 가벼운 메모리 기반의 데이터 저장소를 사용함
*/

}
