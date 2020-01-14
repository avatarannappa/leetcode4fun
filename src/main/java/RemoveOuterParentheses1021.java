import java.util.Stack;

/**
 * 1021. 删除最外层的括号.
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/18
 */
public class RemoveOuterParentheses1021 {
    public String removeOuterParentheses(String S) {
        if (S == null && S.length() == 0) {
            return S;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == '(') {
                    stack.push(c);
                    sb.append(c);
                } else {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
