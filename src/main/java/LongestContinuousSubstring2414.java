/**
 * 2414. 最长的字母序连续子字符串的长度.
 * medium
 *
 * @author avatarannappa
 * @version 2024/9/19
 */
public class LongestContinuousSubstring2414 {

    public int longestContinuousSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int max = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 1;
            }
        }
        max = Math.max(max, cur);
        return max;
    }

    public static void main(String[] args) {
        String s = "abac";
        // 2
        System.out.println(new LongestContinuousSubstring2414().longestContinuousSubstring(s));
    }
}
