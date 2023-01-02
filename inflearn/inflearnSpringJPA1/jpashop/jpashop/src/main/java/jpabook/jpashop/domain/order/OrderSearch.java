package jpabook.jpashop.domain.order;

import jpabook.jpashop.domain.model.OrderStatus;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;
}
