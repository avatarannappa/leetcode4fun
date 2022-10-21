/**
 * 2427. 公因子的数目
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/21
 */
public class CommonFactors2427 {
    public int commonFactors(int a, int b) {
        int gcd = gcd(a, b);
        int ans = 0;
        for (int i = 1; i <= gcd; i++) {
            if (gcd % i == 0) {
                ans++;
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return a < b ? gcd(b, a) : gcd(b, a % b);
    }

    public static void main(String[] args) {
        // a = 25, b = 30
        // 2
        int a = 25;
        int b = 30;
        System.out.println(new CommonFactors2427().commonFactors(a, b));
    }
}
