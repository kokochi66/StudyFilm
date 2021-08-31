package sample2.kokochi.hello.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample2.kokochi.hello.discount.DiscountPolicy;
import sample2.kokochi.hello.member.Member;
import sample2.kokochi.hello.member.repository.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
