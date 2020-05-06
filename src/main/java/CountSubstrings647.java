/**
 * 647. 回文子串
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/7
 */
public class CountSubstrings647 {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && ((i - j) < 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(new CountSubstrings647().countSubstrings(s));
    }
}
