import java.util.Stack;

/**
 * 946. 验证栈序列
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/28
 */
public class ValidateStackSequences946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < popped.length; i++) {
            int pop = popped[i];
            if (!stack.isEmpty() && pop == stack.peek()) {
                stack.pop();
            } else {
                while (j < pushed.length) {
                    int push = pushed[j];
                    stack.push(push);
                    j++;
                    if (pop == push) {
                        break;
                    }
                }
                if (stack.peek() != pop) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        System.out.println(new ValidateStackSequences946().validateStackSequences(pushed, popped));
    }

}
