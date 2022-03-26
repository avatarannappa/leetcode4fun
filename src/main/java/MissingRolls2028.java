import java.util.Arrays;

/**
 * 2028. 找出缺失的观测数据.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/3/27
 */
public class MissingRolls2028 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = mean * (m + n);
        int sumM = Arrays.stream(rolls).sum();
        int sumN = total - sumM;
        if (sumN < n || sumN > 6 * n) {
            return new int[0];
        }
        int[] res = new int[n];
        Arrays.fill(res, sumN / n);
        for (int i = 0; i < sumN % n; i++) {
            res[i]++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] rolls = {1, 2, 3, 4};
        int mean = 6;
        int n = 4;
        System.out.println(Arrays.toString(new MissingRolls2028().missingRolls(rolls, mean, n)));
    }
}
