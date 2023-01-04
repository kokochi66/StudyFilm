package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.order.Order;
import jpabook.jpashop.domain.order.OrderItem;
import jpabook.jpashop.domain.order.OrderQueryDto;
import jpabook.jpashop.domain.order.OrderSearch;
import jpabook.jpashop.repository.OrderQueryRepository;
import jpabook.jpashop.repository.OrderRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderRepository orderRepository;
    private final OrderQueryRepository orderQueryRepository;

    @GetMapping("/api/v1/orders")
    public List<Order> ordersV1() {
        List<Order> list = orderRepository.findAllByString(new OrderSearch());
        for (Order order : list) {
            order.getMember().getName();
            order.getDelivery().getAddress();
            List<OrderItem> orderItems = order.getOrderItems();
            orderItems.stream().forEach(orderItem -> orderItem.getItem().getName());
        }
        return list;
    }

    @GetMapping("/api/v2/orders")
    public List<OrderDto> ordersV2() {
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());
        List<OrderDto> res = orders.stream().map(OrderDto::new).collect(Collectors.toList());
        return res;
    }

    @GetMapping("/api/v3/orders")
    public List<OrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithItem();
        List<OrderDto> res = orders.stream().map(OrderDto::new).collect(Collectors.toList());
        return res;
    }

    @GetMapping("/api/v3.1/orders")
    public List<OrderDto> ordersV3_1_page(@RequestParam(value = "offset", defaultValue = "0")  int offset,
                                          @RequestParam(value = "limit", defaultValue = "100") int limit) {
        List<Order> orders = orderRepository.findAllWithMemberDelivery(offset, limit);
        List<OrderDto> res = orders.stream().map(OrderDto::new).collect(Collectors.toList());
        return res;
    }

    @GetMapping("/api/v4/orders")
    public List<OrderQueryDto> ordersV4() {
        return orderQueryRepository.findOrderQueryDtos();
    }

    @GetMapping("/api/v5/orders")
    public List<OrderQueryDto> ordersV5() {
        return orderQueryRepository.findAllByDto_optimization();
    }

    @Getter
    @Setter
    static class OrderDto {
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private Address address;
        private List<OrderItemDto> orderItems;

        public OrderDto(Order order) {
            this.orderId = order.getId();
            this.name = order.getMember().getName();
            this.orderDate = order.getOrderDate();
            this.address = order.getDelivery().getAddress();
            this.orderItems = order.getOrderItems().stream().map(OrderItemDto::new).collect(Collectors.toList());
        }
    }

    @Getter
    @Setter
    static class OrderItemDto {
        private String itemName;
        private int orderPrice;
        private int count;

        public OrderItemDto(OrderItem orderItem) {
            this.itemName = orderItem.getItem().getName();
            this.orderPrice = orderItem.getOrderPrice();
            this.count = orderItem.getCount();
        }
    }
}
