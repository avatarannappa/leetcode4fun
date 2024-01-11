package test;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author avatarannappa
 * @date 2023/10/9
 */
public class TokenBucketLimiterTest {
    public static void main(String[] args){
        //每秒钟生成5个令牌
        RateLimiter limiter = RateLimiter.create(5);

        //返回值表示从令牌桶中获取一个令牌所花费的时间，单位是秒
        System.out.println(limiter.acquire(10));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
    }
}
