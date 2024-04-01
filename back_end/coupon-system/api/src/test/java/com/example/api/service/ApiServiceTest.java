package com.example.api.service;

import com.example.api.repository.CouponCountRepository;
import com.example.api.repository.CouponRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ApiServiceTest {

    @Autowired
    private ApplyService applyService;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private CouponCountRepository couponCountRepository;

    @Test
    public void 한번만응모() {
        applyService.apply(1L);
        long count = couponRepository.count();
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 여러명응모() throws InterruptedException {
        couponCountRepository.flush("coupon_count");

        int threadCount = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            long userId = i;
            executorService.submit(() -> {
                try {
                    applyService.apply(userId);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();

        Thread.sleep(10000);

        long count = couponRepository.count();
        assertThat(count).isEqualTo(100);
    }
}
