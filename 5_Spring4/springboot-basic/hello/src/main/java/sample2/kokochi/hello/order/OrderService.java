package sample2.kokochi.hello.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
