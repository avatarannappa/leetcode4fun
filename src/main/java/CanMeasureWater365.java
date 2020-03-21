/**
 * 365. 水壶问题
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/21
 */
public class CanMeasureWater365 {

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }

        int l = x % y;
        while (l != 0) {
            x = y;
            y = l;
            l = x % y;
        }

        return z % y == 0;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        int z = 4;
        System.out.println(new CanMeasureWater365().canMeasureWater(x, y, z));
    }
}
