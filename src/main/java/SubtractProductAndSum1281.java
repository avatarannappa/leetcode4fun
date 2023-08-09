/**
 * 1281. 整数的各位积和之差
 * easy
 *
 * @author avatarannappa
 * @date 2023/8/9
 */
public class SubtractProductAndSum1281 {

    public int subtractProductAndSum(int n) {
        // 简单模拟
        int ans = 0;
        int m = 1;
        int s = 0;
        while (n > 0) {
            int a = n % 10;
            n = n / 10;
            m *= a;
            s += a;
        }
        return m - s;
    }
}
