import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * @author chenhao138
 * @date 2023/8/8
 */
public class CompletableTest {

    public static void main(String[] args) {
        //记录开始时间
        Long start = System.currentTimeMillis();

        //定长10线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);

        //任务
        List<Integer> taskList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<String> resultList = Collections.synchronizedList(new ArrayList<>());
        Map<String, String> errorList = new ConcurrentHashMap<>();

        Stream<CompletableFuture<String>> completableFutureStream = taskList.stream()
            .map(num -> {
                    return CompletableFuture
                        .supplyAsync(() -> {
                                return getDouble(num);
                            },
                            executor)
                        .handle(new BiFunction<Integer, Throwable, String>() {
                            @Override
                            public String apply(Integer s, Throwable throwable) {

                                if (throwable == null) {
                                    System.out.println("任务" + num + "完成! result=" + s + ", " + new Date());
                                    resultList.add(s.toString());
                                } else {
                                    System.out.println("任务" + num + "异常! e=" + throwable + ", " + new Date());
                                    errorList.put(num.toString(), throwable.getMessage());
                                }
                                return "";
                            }
                        });
                }
            );

        CompletableFuture[] completableFutures = completableFutureStream.toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(completableFutures)
            .whenComplete((v, th) -> {
                System.out.println("所有任务执行完成触发\n resultList=" + resultList + "\n errorList=" + errorList + "\n耗时=" + (
                    System.currentTimeMillis() - start));
            }).join();

        System.out.println("end");

    }

    //根据数字判断线程休眠的时间
    public static Integer getDouble(Integer i) {
        try {
            if (i == 1) {
                //任务1耗时3秒
                Thread.sleep(3000);
            } else if (i == 2) {
                //任务2耗时1秒,还出错
                Thread.sleep(1000);
                throw new RuntimeException("出异常了");
            } else {
                //其它任务耗时1秒
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2 * i;
    }
}
