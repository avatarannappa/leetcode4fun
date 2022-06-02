import java.util.Arrays;

/**
 * 829. 连续整数求和.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2022/6/3
 */
public class ConsecutiveNumbersSum829 {

    public int consecutiveNumbersSum(int n) {
        // 数学，a开头i个连续数等差数列 s = (a + a + i - 1) * i / 2
        // n = ai + (i - 1) * i / 2
        // a = [n - (i - 1) * i / 2] / i
        // 求整数a，[n - (i - 1) * i / 2] % i == 0，则[n - (i - 1) * i / 2] / i是整数
        int ans = 0;
        for (int i = 1; i <= Math.sqrt(2 * n); i++) {
            ans += (n - i * (i - 1) / 2) % i == 0 ? 1 : 0;
        }
        return ans;
    }

    public int consecutiveNumbersSumOld(int n) {
        // 内存溢出。130 / 170 个通过测试用例
        int ans = 0;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + i;
        }

        int l = 0, r = 1;
        while (r <= n && l <= n) {
            int temp = sum[r] - sum[l];
            if (temp == n) {
                ans++;
                l++;
                r++;
            } else if (temp > n) {
                l++;
            } else {
                r++;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        int n = 15;
        // 4
        System.out.println(new ConsecutiveNumbersSum829().consecutiveNumbersSum(n));
    }
}
