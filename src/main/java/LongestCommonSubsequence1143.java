/**
 * 1143. 最长公共子序列,Longest Common Subsequence. medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/10/11
 */
public class LongestCommonSubsequence1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        // 二维DP，倒着想，顺着推
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(new LongestCommonSubsequence1143().longestCommonSubsequence(text1, text2));
    }

}
