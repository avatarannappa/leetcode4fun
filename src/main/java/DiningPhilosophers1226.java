import java.util.concurrent.Semaphore;

/**
 * 1226. 哲学家进餐
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/4
 */
public class DiningPhilosophers1226 {

    public DiningPhilosophers1226() {

    }

    Semaphore lock = new Semaphore(1);

    // call the run() method of any runnable to execute its code
    public void wantsToEatSemaphore(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
                                    Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
        lock.acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        lock.release();
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
                           Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
        lock.acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        lock.release();
    }
}
