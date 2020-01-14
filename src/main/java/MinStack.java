/**
 * @author avatarannappa
 * @version 1.0, 2018/12/24
 */
public class MinStack {

    private int[] array;
    private int start;
    private int end;
    private int min;
    private int[] minArray;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        array = new int[1000];
        minArray = new int[array.length];
        start = 0;
        end = 0;
    }

    public void push(int x) {
        array[end] = x;
        minArray[end] = min;
        if (end == 0 || x < min) {
            min = x;

        }
        end++;
    }

    public void pop() {
        if (end > start) {
            end--;
            if (array[end] == min) {
                min = minArray[end];
            }
        }
    }

    public int top() {
        int top = end - 1;
        return array[top];
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        int top = minStack.top();
        System.out.println(top);
        min = minStack.getMin();
        System.out.println(min);
    }
}
