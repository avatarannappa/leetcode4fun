/**
 * 514. 自由之路,Freedom Trail. hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/10/20
 */
public class FindRotateSteps514 {

    public int findRotateSteps(String ring, String key) {
        // DP O(n**3) 超过20%
        int[][] dp = new int[key.length() + 1][ring.length() + 1];
        for (int j = 0; j < ring.length(); j++) {
            dp[0][j + 1] = Math.min(j, ring.length() - j);
        }
        for (int i = 1; i <= key.length(); i++) {
            for (int j = 1; j <= ring.length(); j++) {
                dp[i][j] = 1000000;
                if (key.charAt(i - 1) == ring.charAt(j - 1)) {
                    for (int k = 1; k <= ring.length(); k++) {
                        int len = Math.abs(k - j);
                        dp[i][j] = Math.min(dp[i][j], Math.min(len, ring.length() - len) + dp[i - 1][k] + 1);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 1; j <= ring.length(); j++) {
            res = Math.min(dp[key.length()][j], res);
        }
        return res;
    }

    public static void main(String[] args) {
        String ring = "gooddg";
        String key = "gd";
        // 4
        System.out.println(new FindRotateSteps514().findRotateSteps(ring, key));
    }
}
