package test;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * CompletableFuture和ListenableFuture互转工具类.
 *
 * @author avatarannappa
 * @version 2025/3/4
 */
public class CompletableAndListenalbeFutureUtil {

    public static <T> CompletableFuture<T> toCompletableFuture(ListenableFuture<T> listenableFuture, Executor executor) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        Futures.addCallback(listenableFuture, new FutureCallback<T>() {
            @Override
            public void onSuccess(T result) {
                completableFuture.complete(result);
            }

            @Override
            public void onFailure(Throwable t) {
                completableFuture.completeExceptionally(t);
            }
        }, executor);
        return completableFuture;
    }

    public static <T> ListenableFuture<T> toListenableFuture(CompletableFuture<T> completableFuture) {
        if (completableFuture == null) {
            return null;
        }
        return new ListenableFuture<T>() {
            @Override
            public void addListener(Runnable listener, Executor executor) {
                completableFuture.whenCompleteAsync((result, throwable) -> {
                    if (throwable != null) {
                        listener.run();
                    }
                }, executor);
            }

            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return completableFuture.cancel(mayInterruptIfRunning);
            }

            @Override
            public boolean isCancelled() {
                return completableFuture.isCancelled();
            }

            @Override
            public boolean isDone() {
                return completableFuture.isDone();
            }

            @Override
            public T get() throws InterruptedException, ExecutionException {
                return completableFuture.get();
            }

            @Override
            public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return completableFuture.get(timeout, unit);
            }
        };
    }

}
