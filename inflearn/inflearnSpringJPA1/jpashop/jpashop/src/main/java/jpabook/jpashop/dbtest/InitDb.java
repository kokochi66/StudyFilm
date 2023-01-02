package jpabook.jpashop.dbtest;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.order.Delivery;
import jpabook.jpashop.domain.order.Order;
import jpabook.jpashop.domain.order.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class InitDb {


    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }


    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            Member member = Member.builder()
                    .name("userA")
                    .address(Address.builder()
                            .city("seoul")
                            .street("1")
                            .zipcode("1111")
                            .build())
                    .orders(new ArrayList<>())
                    .build();
            em.persist(member);

            Book book1 = createBook("JPA1 book", 10000, 100);
            em.persist(book1);

            Book book2 = createBook("JPA2 book", 5000 , 100);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 5000, 2);

            Order order = Order.createOrder(member,
                    Delivery.builder()
                            .address(member.getAddress()).build(),
                    orderItem1, orderItem2);
            em.persist(order);

        }

        public void dbInit2() {
            Member member = Member.builder()
                    .name("userA")
                    .address(Address.builder()
                            .city("jinju")
                            .street("2")
                            .zipcode("2222")
                            .build())
                    .orders(new ArrayList<>())
                    .build();
            em.persist(member);

            Book book1 = createBook("JPA1 book", 20000, 200);
            em.persist(book1);

            Book book2 = createBook("JPA2 book", 30000, 300);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 3);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 5000, 4);

            Order order = Order.createOrder(member,
                    Delivery.builder()
                            .address(member.getAddress()).build(),
                    orderItem1, orderItem2);
            em.persist(order);

        }

    }

    private static Book createBook(String name, int price, int stockQuantity) {
        Book book1 = new Book();
        book1.setName(name);
        book1.setPrice(price);
        book1.setStockQuantity(stockQuantity);
        return book1;
    }
}
