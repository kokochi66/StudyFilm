package sample2.kokochi.hello.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample2.kokochi.hello.discount.DiscountPolicy;
import sample2.kokochi.hello.member.Member;
import sample2.kokochi.hello.member.repository.MemberRepository;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // 1. @Autowired 필드명 매칭 :: @Autowired는 타입매칭을 시도하고 ,여러빈이 있으면 파라미터 이름으로 빈 이름을 추가 매칭한다.
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicyImpl) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = rateDiscountPolicyImpl;
//    }
    // lombok이 해당 생성자를 자동으로 생성해준다.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
