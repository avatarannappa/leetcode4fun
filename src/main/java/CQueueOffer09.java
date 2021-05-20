import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/20
 */
public class CQueueOffer09 {

    Stack<Integer> s0 = new Stack<>();
    Stack<Integer> s1 = new Stack<>();

    public CQueueOffer09() {

    }

    public void appendTail(int value) {
        s0.push(value);
    }

    public int deleteHead() {
        if (!s1.isEmpty()) {
            return s1.pop();
        } else {
            while (!s0.isEmpty()) {
                s1.push(s0.pop());
            }
            if (!s1.isEmpty()) {
                return s1.pop();
            } else {
                return -1;
            }
        }
    }
}
