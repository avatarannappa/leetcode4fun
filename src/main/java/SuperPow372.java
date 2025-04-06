/**
 * 372. 超级次方.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/10
 */
public class SuperPow372 {

    // a ^ [1,2,3] = a ^ 3 * (a ^ [1, 2]) ^ 10
    // (a * b) % mod = (a % mod) * (b % mod) % mod
    int mod = 1337;

    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length - 1);
    }

    public int superPow(int a, int[] b, int index) {
        if (index < 0) {
            return 1;
        }
        int m = 0;
        int n = 0;
        m = myPow(a, b[index]);
        n = myPow(superPow(a, b, index - 1), 10);
        return m * n % mod;
    }

    private int myPow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        a %= mod;
        if (b % 2 == 1) {
            return a * myPow(a, b - 1) % mod;
        } else {
            int temp = myPow(a, b / 2);
            return temp * temp % mod;
        }
    }

    public int superPowNew(int a, int[] b) {
        return superPowNew(a, b, b.length - 1);
    }

    public int superPowNew(int a, int[] b, int index) {
        // 递归+快速幂
        if (index < 0) {
            return 1;
        }
        int m = 0;
        int n = 0;
        m = myPowNew(a, b[index]);
        n = myPowNew(superPowNew(a, b, index - 1), 10);
        return m * n % mod;
    }

    private int myPowNew(int a, int b) {
        int res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b = b >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        int[] b = {2, 0, 0};
        // 1198
        System.out.println(new SuperPow372().superPow(a, b));
    }
}
