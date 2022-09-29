import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1106. 解析布尔表达式
 * hard
 *
 * @author avatarannappa
 * @date 2022/9/29
 */
public class ParseBoolExpr1106 {

    public boolean parseBoolExpr(String expression) {
        char c = expression.charAt(0);
        switch (c) {
            case 't':
                return true;
            case 'f':
                return false;
            case '!':
                return !parseBoolExpr(expression.substring(2, expression.length() - 1));
            case '&':
                String tempExpression = expression.substring(2, expression.length() - 1);
                List<String> arr = split(tempExpression);
                boolean ans = true;
                for (String s : arr) {
                    ans &= parseBoolExpr(s);
                }
                return ans;
            case '|':
                tempExpression = expression.substring(2, expression.length() - 1);
                arr = split(tempExpression);
                ans = false;
                for (String s : arr) {
                    ans |= parseBoolExpr(s);
                }
                return ans;
        }
        return false;
    }

    private List<String> split(String expression) {
        List<String> ans = new LinkedList<>();
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ',' && stack.size() == 1) {
                ans.add(stack.pop());
            } else if (c == ')') {
                String str = ")";
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    str = stack.pop() + str;
                }
                str = stack.pop() + str;
                str = stack.pop() + str;
                stack.push(str);
            } else {
                stack.push(String.valueOf(c));
            }
        }
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    public static void main(String[] args) {
        // 输入：expression = "|(&(t,f,t),!(t))"
        // 输出：false
        String expression = "|(&(t,f,t),!(|(&(t,f,t),!(t))))";
        System.out.println(new ParseBoolExpr1106().parseBoolExpr(expression));
    }
}
