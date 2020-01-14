/**
 * 50.pow
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * @author avatarannappa
 * @version 1.0, 2019/6/12
 */
public class MyPow {
    public static void main(String[] args) {
        double x = 2.1;
        int n = 3;
        System.out.println(myPow(x, n));
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
