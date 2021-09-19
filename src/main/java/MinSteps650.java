/**
 * 650. 只有两个键的键盘,2 Keys Keyboard. medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/09/19
 */
public class MinSteps650 {

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 2; i <= n / 2; i++) {
            for (int j = 2; j * i <= n; j++) {
                dp[j * i] = Math.min(dp[i] + j, dp[j * i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] argms) {
        int m = 9;
        System.out.println("m:" + m + "," + new MinSteps650().minSteps(m));
        for (int i = 1; i < 20; i++) {
            int n = i;
            System.out.println("n:" + n + "," + new MinSteps650().minSteps(n));
        }

    }
}
