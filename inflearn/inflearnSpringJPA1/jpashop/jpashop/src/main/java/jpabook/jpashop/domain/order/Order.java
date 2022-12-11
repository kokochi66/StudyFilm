package jpabook.jpashop.domain.order;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.model.DeliveryStatus;
import jpabook.jpashop.domain.model.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Table(name = "orders")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; // 주문시간

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus status; // 주문상태

    // 연관관계 메소드 => 양방향일 때, 양방향 모두에 세팅될 수 있도록 설정
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        return Order.builder()
                .member(member)
                .delivery(delivery)
                .status(OrderStatus.ORDER)
                .orderDate(LocalDateTime.now())
                .orderItems(Arrays.stream(orderItems).collect(Collectors.toList()))
                .build();
    }

    public void cancel() {
        if (this.delivery.getStatus() == DeliveryStatus.COMP) {
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }
        this.setStatus(OrderStatus.CANCEL);
        this.orderItems.forEach(OrderItem::cancel);
    }

    public int getTotalPrice() {
        return this.orderItems.stream().mapToInt(OrderItem::getTotalPrice).sum();
    }
}
