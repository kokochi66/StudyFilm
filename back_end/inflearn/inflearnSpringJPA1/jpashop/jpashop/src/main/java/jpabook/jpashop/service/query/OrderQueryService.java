package jpabook.jpashop.service.query;

import jpabook.jpashop.api.OrderApiController;
import jpabook.jpashop.domain.order.Order;
import jpabook.jpashop.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
@AllArgsConstructor
public class OrderQueryService {

    final private OrderRepository orderRepository;

    public List<OrderApiController.OrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithItem();
        List<OrderApiController.OrderDto> res = orders.stream().map(OrderApiController.OrderDto::new).collect(Collectors.toList());
        return res;
    }
}
