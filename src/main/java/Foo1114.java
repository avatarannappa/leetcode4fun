import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1114. 按序打印.
 * https://zhuanlan.zhihu.com/p/81626432
 * 1.CountDownLatch, 2.Semaphore, 3.Lock, 4.无锁volatile, 5.CyclicBarrier
 *
 * @author avatarannappa
 * @version 1.0, 2019/10/30
 */
public class Foo1114 {

    public Foo1114() {

    }

    CountDownLatch stage1 = new CountDownLatch(1);
    CountDownLatch stage2 = new CountDownLatch(1);

    public void first1(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        stage1.countDown();
    }

    public void second1(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        stage1.await();
        printSecond.run();
        stage2.countDown();
    }

    public void third1(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        stage2.await();
        printThird.run();
        stage2.countDown();
    }

    Semaphore sFirst = new Semaphore(1);
    Semaphore sSecond = new Semaphore(0);
    Semaphore sThird = new Semaphore(0);

    public void first2(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        sFirst.acquire();
        printFirst.run();
        sSecond.release();
    }

    public void second2(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        sSecond.acquire();
        printSecond.run();
        sThird.release();
    }

    public void third2(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        sThird.acquire();
        printThird.run();
    }

    Lock lock = new ReentrantLock();
    volatile int stage = 1;
    Condition cF = lock.newCondition();
    Condition cS = lock.newCondition();


    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        lock.lock();
        try {
            printFirst.run();
            stage = 2;
            cF.signal();
        } finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        lock.lock();
        try {
            while (stage != 2) {
                cF.await();
            }
            printSecond.run();
            stage = 3;
            cS.signal();
        } finally {
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        lock.lock();
        try {
            while (stage != 3) {
                cS.await();
            }
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}
