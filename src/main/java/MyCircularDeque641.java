/**
 * 641. 设计循环双端队列.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/24
 */
public class MyCircularDeque641 {

    int[] array;
    int headIndex = 0;
    int endIndex = 0;
    boolean isEmpty = true;
    int k;

    public MyCircularDeque641(int k) {
        array = new int[k];
        this.k = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        headIndex = (headIndex - 1 + k) % k;
        array[headIndex] = value;
        isEmpty = false;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        array[endIndex] = value;
        endIndex = (endIndex + 1) % k;
        isEmpty = false;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        headIndex = (headIndex + 1) % k;
        if (headIndex == endIndex) {
            isEmpty = true;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        endIndex = (endIndex - 1 + k) % k;
        if (headIndex == endIndex) {
            isEmpty = true;
        }
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[headIndex];
    }

    public int getRear() {
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
