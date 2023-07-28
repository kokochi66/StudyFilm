package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jpabook.jpashop.domain.order.Order;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    @Column(name = "member_name")
    private String name;

    @Embedded
    private Address address;

    @JsonIgnore // 무시되어야 하는 값들이 밖으로 나가지 않게 해줌
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
