import java.util.Stack;

/**
 * 38. 报数
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/31
 */
public class CountAndSay38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return say(countAndSay(n - 1));
    }

    private String say(String str) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                temp = 1;
            } else {
                Character cs = stack.peek();
                if (c.equals(cs)) {
                    temp++;
                } else {
                    result = result + temp + cs;
                    stack.pop();
                    stack.push(c);
                    temp = 1;
                }
            }
        }
        result = result + temp + stack.pop();
        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(new CountAndSay38().countAndSay(n));
    }
}
