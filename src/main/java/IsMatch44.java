import java.util.Arrays;

/**
 * 44. 通配符匹配.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/11
 */
public class IsMatch44 {

    public boolean isMatch(String s, String p) {
        // 动态规划
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "acdcb";
        String p = "a*c?b";
        System.out.println(new IsMatch44().isMatch(s, p));

        boolean[] test = new boolean[3];
        System.out.println(Arrays.toString(test));
    }
}
