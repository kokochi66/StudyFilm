package Study.datajpa.controller;

import Study.datajpa.entity.Member;
import Study.datajpa.repository.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Long id) {
        return memberRepository.findById(id).get().getName();
    }

    @GetMapping("/members2/{id}")
    public String findMember2(@PathVariable("id") Member member) {
        return member.getName();
        // 편해보이지만 별로 권장하지는 않음 (어디서 어떻게 조회되는지 찾기가 어려움)
        // 영속성 컨텍스트 범위나 정의가 애매해서, 데이터 변경 없이 조회용으로만 사용하는 것이 권장됨.
    }

    @GetMapping("/members")
    public Page<Member> list(@PageableDefault(size = 5) Pageable pageable) {
        // page의 속성을 다양하게 이용할 수 있다.
        // @PagerableDefault를 사용하면 다양한 커스텀한 디폴트 페이징 설정을 줄 수 있다.
        // 페이징 정보가 둘 이상이면 @Qualifier를 사용하여 구분하면 된다.
        return memberRepository.findAll(pageable);
    }

    @PostConstruct
    public void init() {
        for (int i=0;i<100;i++) {
            memberRepository.save(Member.createMember("kokochi_" + i, i));
        }

    }
}
