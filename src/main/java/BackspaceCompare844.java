import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/19
 */
public class BackspaceCompare844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        char[] sArray = S.toCharArray();
        for (char s : sArray) {
            if (s == '#') {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(s);
            }
        }

        char[] tArray = T.toCharArray();
        for (char t : tArray) {
            if (t == '#') {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(t);
            }
        }

        String sResult = "";
        String tResult = "";
        while (!sStack.isEmpty()) {
            sResult = sStack.pop() + sResult;
        }

        while (!tStack.isEmpty()) {
            tResult = tStack.pop() + tResult;
        }

        return sResult.equals(tResult);
    }
}
