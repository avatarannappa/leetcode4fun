import java.util.Stack;

/**
 * 150. 逆波兰表达式求值.
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/17
 */
public class EvalRPN150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                int a = stack.pop();
                stack.push(stack.pop() / a);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public int evalRPNMe(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int c = a + b;
                stack.push(String.valueOf(c));
            } else if ("-".equals(token)) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int c = b - a;
                stack.push(String.valueOf(c));
            } else if ("*".equals(token)) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int c = a * b;
                stack.push(String.valueOf(c));
            } else if ("/".equals(token)) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int c = b / a;
                stack.push(String.valueOf(c));
            } else {
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        String[] array = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvalRPN150().evalRPN(array));
    }

    private boolean operator(String token) {
        // 写成if else，考虑到会直接根据符号运算，移到evalRPN中。果然operator用不到，直接判断运算放一起了
        if ("+".equals(token)) {
            return true;
        } else if ("-".equals(token)) {
            return true;
        } else if ("*".equals(token)) {
            return true;
        } else if ("/".equals(token)) {
            return true;
        } else {
            return false;
        }
    }
}
