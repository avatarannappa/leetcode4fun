import java.util.Stack;

/**
 * 394. 字符串解码.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/16
 */
public class DecodeString394 {

    public String decodeString(String s) {
        String result = "";
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : array) {
            if (c == ']') {
                String temp = "";
                while (stack.peek() != '[') {
                    temp = stack.pop() + temp;
                }
                // pop [
                stack.pop();
                String countStr = "";
                while (!stack.isEmpty() && (stack.peek() >= '0' && stack.peek() <= '9')) {
                    countStr = stack.pop() + countStr;
                }
                int count = Integer.parseInt(countStr);
                String rtemp = "";
                for (int i = 0; i < count; i++) {
                    rtemp += temp;
                }
                for (int i = 0; i < rtemp.length(); i++) {
                    stack.push(rtemp.charAt(i));
                }
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(new DecodeString394().decodeString(s));
    }
}
