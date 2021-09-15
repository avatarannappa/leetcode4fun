import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 284. 顶端迭代器 medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/15
 */
class PeekingIterator284 implements Iterator<Integer> {

    Deque<Integer> list = new LinkedList<>();

    public PeekingIterator284(Iterator<Integer> iterator) {
        // initialize any member here.
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return list.pollFirst();
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }
}