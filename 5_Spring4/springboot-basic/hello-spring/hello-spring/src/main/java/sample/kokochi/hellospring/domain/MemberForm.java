package sample.kokochi.hellospring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter @ToString @NoArgsConstructor
public class MemberForm {
    private String name;
}
