/**
 * 115. 不同的子序列.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/15
 */
public class NumDistinct115 {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    public int numDistinctOld(String s, String t) {
        // 超时 easy模式
        int count = 0;
        if (t.equals("")) {
            return 1;
        }
        if (s.length() < t.length()) {
            return 0;
        }
        char now = t.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (now == s.charAt(i)) {
                count += numDistinct(s.substring(i + 1), t.substring(1));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //        String s = "babgbag";
        //        String t = "bag";
        String s =
                "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebc" +
                "deabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
        String t = "bcddceeeebecbc";
        System.out.println(new NumDistinct115().numDistinct(s, t));
    }
}
