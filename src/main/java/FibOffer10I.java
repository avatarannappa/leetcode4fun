/**
 * 剑指 Offer 10- I. 斐波那契数列
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/21
 */
public class FibOffer10I {

    public int fib(int n) {
        int a = 0;
        int b = 1;
        int c;
        for (int i = 0; i < n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return a;
    }

}
