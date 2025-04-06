package test;

/**
 * 线程中断测试.
 *
 * @author avatarannappa
 * @version 2025/3/7
 */
public class ThreadInterruptedTest {

    public static class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.printf("i=%d%n", i);
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        thread.interrupt();
        Thread.currentThread().interrupt();
        System.out.println("第一次调用Thread.currentThread().interrupt()："
                +Thread.currentThread().isInterrupted());
        System.out.println("第一次调用thread.interrupted()："
                +Thread.currentThread().interrupted());
        System.out.println("第二次调用thread.interrupted()："
                +Thread.currentThread().interrupted());
        // 关于这三个方法，interrupt（）是给线程设置中断标志；
        //
        //　　　　　　　　　　interrupted（）是检测中断并清除中断状态；
        //
        //　　　　　　　　　　isInterrupted（）只检测中断。
        //
        //　　还有重要的一点就是interrupted（）作用于当前线程，interrupt（）和isInterrupted（）作用于此线程，即代码中调用此方法的实例所代表的线程。

    }
}

