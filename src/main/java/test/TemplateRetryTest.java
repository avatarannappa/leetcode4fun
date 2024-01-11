package test;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author avatarannappa
 * @date 2024/1/11
 */
public class TemplateRetryTest {

    public static void main(String[] args) {
        System.out.println(TemplateRetryTest.use());
    }
    
    public static RetryTemplate getRetryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
        //定义重试时间
        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(500);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
        //定义重试次数
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(3);
        retryTemplate.setRetryPolicy(retryPolicy);
        return retryTemplate;
    }
    
    public static Boolean use() {
        RetryTemplate retryTemplate = getRetryTemplate();
        AtomicInteger counter = new AtomicInteger();
        try {
            return retryTemplate.execute(retryCallback -> {
                System.out.println("try:" + counter.get());
                if (counter.incrementAndGet() < 2) {
                    throw new Exception("try exception, " + counter.get());
                }
                return true;
            }, recoveryCallback -> {
                System.out.println("retry:" + counter.get());
                return false;
            });
        } catch (Exception e) {
            System.out.println("catch:" + counter.get());
            return false;
        }
    }
}
