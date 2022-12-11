package jpabook.jpashop.service;

import jpabook.jpashop.domain.order.Delivery;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.order.Order;
import jpabook.jpashop.domain.order.OrderItem;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    final private OrderRepository orderRepository;
    final private MemberRepository memberRepository;
    final private ItemRepository itemRepository;

    //  주문
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        // 배송정보 생성
        Delivery delivery = Delivery.builder()
                .address(member.getAddress()).build();

        // 상품 아이템 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);
        orderRepository.save(order);
        return order.getId();
    }

    // 취소
    @Transactional
    public void cancelOrder(Long orderId) {
        orderRepository.findOne(orderId).cancel();
    }

    // 검색 - 나중에
}
