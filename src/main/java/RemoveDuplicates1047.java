import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 1047. 删除字符串中的所有相邻重复项
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/15
 */
public class RemoveDuplicates1047 {
    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        String result = "";
        char[] array = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }


        if (!stack.isEmpty()) {
            for (Character character : stack) {
                result += character;
            }
        }
        return result;
    }
}
