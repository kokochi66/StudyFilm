package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.order.Order;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.model.OrderStatus;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    // 주문
    @Test
    public void 상품주문() throws Exception {
        int itemStockQuantity = 100;
        int orderCount = 2;
        int itemPrice = 10000;
        Long savedOrderId = createTestOrder(itemStockQuantity, orderCount, itemPrice);
        Order testOrder = orderRepository.findOne(savedOrderId);
        Assert.assertEquals(" 상품 주문시 상태는 ORDER", OrderStatus.ORDER, testOrder.getStatus());
        Assert.assertEquals("주문한 상품 종류 수가 정확한지?", 1, testOrder.getOrderItems().size());
        Assert.assertEquals("주문 가격이 정확한지?", itemPrice * orderCount, testOrder.getTotalPrice());
        Assert.assertEquals("재고가 정상적으로 줄어들었는지?", itemStockQuantity - orderCount, testOrder.getOrderItems().stream().findAny().get().getItem().getStockQuantity());
    }



    // 재고 수량 초과
    @Test(expected = NotEnoughStockException.class)
    public void 상품주문_재고수량초과() throws Exception {
        int itemStockQuantity = 3;
        int orderCount = 5;
        int itemPrice = 10000;
        createTestOrder(itemStockQuantity, orderCount, itemPrice);
        Assert.fail("재고 수량 부족 체크 실패");
    }


    // 주문 취소
    @Test
    public void 주문취소() throws Exception {
        int itemStockQuantity = 10;
        int orderCount = 5;
        int itemPrice = 10000;
        Long orderId = createTestOrder(itemStockQuantity, orderCount, itemPrice);

        orderService.cancelOrder(orderId);
        Order canceledOrder = orderRepository.findOne(orderId);
        Assert.assertEquals("주문 취소시 상태는 CANCEL", OrderStatus.CANCEL, canceledOrder.getStatus());
        Assert.assertEquals("재고 원복이 되었는지?", itemStockQuantity, canceledOrder.getOrderItems().stream().findAny().get().getItem().getStockQuantity());
    }



    private Book createTestBook(int itemStockQuantity, int price) {
        Book book = new Book();
        book.setName("JPA에 대해서");
        book.setPrice(price);
        book.setStockQuantity(itemStockQuantity);
        em.persist(book);
        return book;
    }

    private Member createTestMember() {
        Member member = Member.builder()
                .name("jaewon")
                .address(Address.builder()
                        .city("경기도")
                        .street("성남시")
                        .zipcode("분당동").build()).build();
        em.persist(member);
        return member;
    }


    private Long createTestOrder(int itemStockQuantity, int orderCount, int price) {
        Member member = createTestMember();
        Book book = createTestBook(itemStockQuantity, price);
        return orderService.order(member.getId(), book.getId(), orderCount);
    }
}