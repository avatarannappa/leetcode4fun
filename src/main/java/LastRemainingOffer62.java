/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/6
 */
public class LastRemainingOffer62 {

    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        // f(n,m)=[(m-1)%n+x+1]%n 约瑟夫环
        int index = lastRemaining(n - 1, m);
        return (index + m) % n;
    }

    public static void main(String[] args) {
        int n = 10;
        int m = 17;
        System.out.println(new LastRemainingOffer62().lastRemaining(n, m));
    }
}
