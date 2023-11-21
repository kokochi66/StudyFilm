package com.example.api.service;

import com.example.api.domain.Coupon;
import com.example.api.repository.CouponCountRepository;
import com.example.api.repository.CouponRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplyService {

    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;

    public void apply(Long userId) {
        Long count = couponCountRepository.increment();

        if (count > 100) {
            return;
        }

        couponRepository.save(new Coupon(userId));
    }
    /*
    * 싱글스레드로 해당 로직이 돌아간다면 무조건, 오류가 발생하지 않을 것이다.
    * 그러나 스프링은 멀티스레드로 로직이 돌아가기 때문에, 동시접근 이슈가 발생할 수 있다.
    *
    * synchronized를 사용하면 당장 해결할 수 있으나, 이는 서버가 여러대가 돌아가는 경우 유효하지 않다.
    * lock을 사용하려면, 쿠폰 발급부터, 쿠폰에 대한 정보를 가져오는 부분까지 락을 걸어야 하기 때문에 성능에 영향이 있다. (싱글스레드로 돌아가는것과 거의 차이가 없다.)
    *
    * 이럴 때, 쿠폰의 개수에 대한 부분만 제어하면 된다.
    * Redis의 incr명령어를 사용해서 해결할 수 있다.
    *
    * incr => ++와 같은 의미. 특정한 키값의 데이터를 1씩 늘리는 연산을 함 (간단한 연산이기 때문에 성능적으로도 이슈가 없다.)
    *
    * */
}
