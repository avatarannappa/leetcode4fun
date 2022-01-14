import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1614. 括号的最大嵌套深度.
 * easy.
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/14
 */
public class MaxDepth1614 {

    public int maxDepth(String s) {
        // 栈
        int ans = 0;

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                ans = Math.max(ans, stack.size());
            } else if (c == ')') {
                stack.pop();
            }
        }
        return ans;
    }

    public int maxDepthNew(String s) {
        // 模拟
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
