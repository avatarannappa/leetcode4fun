import java.util.concurrent.Semaphore;

public class FizzBuzz1195 {

    private int n;

    public FizzBuzz1195(int n) {
        this.n = n;
    }

    Semaphore f = new Semaphore(0);
    Semaphore b = new Semaphore(0);
    Semaphore fb = new Semaphore(0);
    Semaphore ns = new Semaphore(1);

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                f.acquire();
                printFizz.run();
                ns.release();
            }
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 != 0) {
                b.acquire();
                printBuzz.run();
                ns.release();
            }
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                fb.acquire();
                printFizzBuzz.run();
                ns.release();
            }
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ns.acquire();
                fb.release();
            } else if (i % 3 == 0) {
                ns.acquire();
                f.release();
            } else if (i % 5 == 0) {
                ns.acquire();
                b.release();
            } else {
                ns.acquire();
                printNumber.accept(i);
                ns.release();
            }
        }
    }
}
