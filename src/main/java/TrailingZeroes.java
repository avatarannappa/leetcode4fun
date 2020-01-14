/**
 * 172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * @author avatarannappa
 * @version 1.0, 2019/6/10
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }

    public static int trailingZeroes(int n) {
        int result = 0;
        while (n / 5 > 0) {
            result += n / 5;
            n = n /5;
        }

        return result;
    }
}
