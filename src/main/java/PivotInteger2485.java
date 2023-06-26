/**
 * 2485. 找出中枢整数
 * easy
 *
 * @author avatarannappa
 * @date 2023/6/26
 */
public class PivotInteger2485 {

    public int pivotInteger(int n) {
        // 数学
        int t = (n * n + n) / 2;
        int x = (int) Math.sqrt(t);
        if (x * x == t) {
            return x;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 8;
        // 6
        System.out.println(new PivotInteger2485().pivotInteger(n));
    }
}
