package com.example.api.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CouponCountRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public void flush(String key) {
        redisTemplate.delete(key);
    }


    public Long increment() {
        return redisTemplate
                .opsForValue()
                .increment("coupon_count");

    }
}
