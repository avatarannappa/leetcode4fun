/**
 * 622. 设计循环队列.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/23
 */
public class MyCircularQueue622 {
    int[] array;
    int headIndex = 0;
    int endIndex = 0;
    boolean isEmpty = true;
    int k;

    public MyCircularQueue622(int k) {
        array = new int[k];
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        array[endIndex] = value;
        endIndex = (endIndex + 1) % k;
        isEmpty = false;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        headIndex = (headIndex + 1) % k;
        if (headIndex == endIndex) {
            isEmpty = true;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[headIndex];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return array[(endIndex - 1 + k) % k];
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isFull() {
        return !isEmpty && headIndex == endIndex;
    }
}
