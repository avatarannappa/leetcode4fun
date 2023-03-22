package test;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author avatarannappa
 * @date 2022/10/28
 */
public class ListenableFutureTest {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
            
        SettableFuture settableFuture = SettableFuture.create();
        // settableFuture.set(null);
        
        ListenableFuture future = settableFuture;
        settableFuture.set(null);
        future.addListener(() -> {
            System.out.println("run listener.");
        }, executorService);

        
        
        future.get();
        System.out.println("---main end---");
    }
    
}
