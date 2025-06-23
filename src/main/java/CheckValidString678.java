import java.util.Stack;

/**
 * 678. 有效的括号字符串.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2025/6/23
 */
public class CheckValidString678 {

    public boolean checkValidString(String s) {
        // 栈 + 贪心
        Stack<Integer> parenStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                parenStack.push(i);
            } else if (c == '*') {
                asteriskStack.push(i);
            } else {
                if (!parenStack.isEmpty()) {
                    parenStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!parenStack.isEmpty() && !asteriskStack.isEmpty()) {
            if (parenStack.pop() > asteriskStack.pop()) {
                return false;
            }
        }
        return parenStack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(*)";
        // true
        System.out.println(new CheckValidString678().checkValidString(s));
    }
}
