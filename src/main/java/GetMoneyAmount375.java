/**
 * 375. 猜数字大小 II. medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/8/26
 */
public class GetMoneyAmount375 {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int min = Integer.MAX_VALUE;
                for (int now = start; now < start + len - 1; now++) {
                    int temp = now + Math.max(dp[start][now - 1], dp[now + 1][start + len - 1]);
                    min = Math.min(min, temp);
                }
                dp[start][start + len - 1] = min;
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int n = 10;
        // res = 16
        System.out.println(new GetMoneyAmount375().getMoneyAmount(n));
    }
}
