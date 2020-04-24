import java.util.Stack;

/**
 * 32. 最长有效括号.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/23
 */
public class LongestValidParentheses32 {

    public int longestValidParentheses(String s) {
        int max = 0;
        if (s == null || s.length() < 2) {
            return max;
        }
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c == '(') {
                stack.push(c);
                stack2.push(-1);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    int t = 0;
                    while (!stack2.isEmpty() && stack2.peek() != -1) {
                        t += stack2.pop();
                    }
                    stack2.pop();
                    stack2.push(t + 2);
                } else {
                    stack.push(c);
                    stack2.push(-1);
                }
            }
        }

        int temp = 0;
        for (Integer i : stack2) {
            if (i == -1) {
                temp = 0;
            } else {
                temp += i;
                if (temp > max) {
                    max = temp;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = ")()())()";
        System.out.println(new LongestValidParentheses32().longestValidParentheses(s));
    }
}
