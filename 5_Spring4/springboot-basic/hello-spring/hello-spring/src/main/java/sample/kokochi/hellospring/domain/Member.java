package sample.kokochi.hellospring.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private Long id;
    private String name;
}
