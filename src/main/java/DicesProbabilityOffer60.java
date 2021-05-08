import java.util.Arrays;

/**
 * 剑指 Offer 60. n个骰子的点数
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/8
 */
public class DicesProbabilityOffer60 {

    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DicesProbabilityOffer60().dicesProbability(2)));
    }
}
