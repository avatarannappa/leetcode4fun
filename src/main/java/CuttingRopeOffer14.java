/**
 * 剑指 Offer 14- II. 剪绳子 II
 * medium
 * 同343
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/18
 */
public class CuttingRopeOffer14 {

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long result = 1;
        while (n > 4) {
            n -= 3;
            result *= 3;
            result %= 1000000007;
        }
        return (int) (n * result % 1000000007);
    }

    public static void main(String[] args) {
        int n = 120;
        // 953271190
        System.out.println(new CuttingRopeOffer14().cuttingRope(120));
    }
}
