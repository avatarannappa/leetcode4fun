/**
 * 521. 最长特殊序列 Ⅰ
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/6
 */
public class FindLUSlength521 {
    public int findLUSlength(String a, String b) {
        int result = -1;
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return -1;
        }
        if (!b.contains(a) && !a.contains(b)) {
            return Math.max(a.length(), b.length());
        } else if (!b.contains(a)) {
            return a.length();
        } else if (!a.contains(b)) {
            return b.length();
        } else {
            return -1;
        }
    }
}
