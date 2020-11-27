/**
 * 343. 整数拆分
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/27
 */
public class IntegerBreak343 {

    public int integerBreak(int n) {
        // 动态规划 或 数学法 e = 2.71828 约等于2、3；代入 f(x) = x ^ (n/x)
        if (n <= 3) {
            return n - 1;
        }
        int result;
        int div = n / 3;
        if (n % 3 == 0) {
            result = (int) Math.pow(3, div);
        } else if (n % 3 == 1) {
            result = (int) (Math.pow(3, div - 1) * 4);
        } else {
            result = (int) (Math.pow(3, div) * 2);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new IntegerBreak343().integerBreak(n));
    }
}
