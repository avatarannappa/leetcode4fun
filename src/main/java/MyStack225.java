import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/8
 */
public class MyStack225 {

    /**
     * Initialize your data structure here.
     */
    public MyStack225() {

    }

    public Queue<Integer> q1 = new LinkedList<>();
    public Queue<Integer> q2 = new LinkedList<>();
    public int sign = 1;

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (sign == 1) {
            q1.offer(x);
        } else {
            q2.offer(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        Integer i = 0;
        if (sign == 1) {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            i = q1.poll();
            sign = 2;
        } else {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            i = q2.poll();
            sign = 1;
        }
        return i == null ? 0 : i;
    }

    /**
     * Get the top element.
     */
    public int top() {
        Integer i = 0;
        if (sign == 1) {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            i = q1.peek();
        } else {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            i = q2.peek();
        }
        return i == null ? 0 : i;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q2.isEmpty() && q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack225 stack = new MyStack225();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

}
