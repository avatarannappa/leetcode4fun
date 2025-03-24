/**
 * 50.pow
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2019/6/12
 */
public class MyPow50 {

    public static void main(String[] args) {
        double x = 2;
        int n = -2147483648;
        System.out.println(myPowNew(x, n));
    }

    public static double myPowNew(double x, int n) {
        // 快速幂，n 转为 long 防止负数转正数溢出
        long m = n;
        if (m < 0) {
            x = 1 / x;
            m = -m;
        }
        double ans = 1.0;
        double y = x;
        while (m > 0) {
            if ((m & 1) == 1) {
                ans *= y;
            }
            y *= y;
            m = m >> 1;
        }

        return ans;
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            return 1 / pow(x, n);
        } else {
            return pow(x, n);
        }
    }

    public static double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
