import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301. 删除无效的括号.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/10
 */
public class RemoveInvalidParentheses301 {

    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = 0;
        for (char c : chars) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        backTrack(chars, new StringBuilder(), 0, 0, 0, l, r);
        return new ArrayList<>(result);
    }

    public void backTrack(char[] chars, StringBuilder sb, int index, int l, int r, int lr, int rr) {
        if (chars.length == index) {
            if (0 == lr && 0 == rr) {
                String str = sb.toString();
                if (check(str)) {
                    result.add(str);
                }
            }
            return;
        }
        char c = chars[index];
        if (c == '(' && lr > 0) {
            backTrack(chars, sb, index + 1, l, r, lr - 1, rr);
        } else if (c == ')' && rr > 0) {
            backTrack(chars, sb, index + 1, l, r, lr, rr - 1);
        }
        sb.append(c);
        if (c == '(') {
            backTrack(chars, sb, index + 1, l + 1, r, lr, rr);
        } else if (c == ')') {
            backTrack(chars, sb, index + 1, l, r + 1, lr, rr);
        } else {
            backTrack(chars, sb, index + 1, l, r, lr, rr);
        }
        sb.deleteCharAt(sb.length()-1);
    }

    public boolean check(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = 0;
        for (char c : chars) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        if (l == 0 && r == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "(a)())()";
        System.out.println(new RemoveInvalidParentheses301().removeInvalidParentheses(s));
    }

}
