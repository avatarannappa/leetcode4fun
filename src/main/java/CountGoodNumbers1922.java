/**
 * 1922. 统计好数字的数目.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2025/4/13
 */
public class CountGoodNumbers1922 {

    private static final int mod = 1000000007;

    public int countGoodNumbers(long n) {
        // 乘法原理 + 快速幂
        return (int) (pow(5, (n + 1) / 2) * pow(4, n / 2) % mod);
    }

    public long pow(long i, long j) {
        long res = 1;
        while (j > 0) {
            if ((j & 1) == 1) {
                res = res * i % mod;
            }
            i = i * i % mod;
            j = j >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        long n = 50;
        // 564908303
        System.out.println(new CountGoodNumbers1922().countGoodNumbers(n));
    }

}
