/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author avatarannappa
 * @version 1.0, 2019/6/13
 */
public class Reverse7 {
    public static void main(String[] args) {
        int a = 1463847412;
        System.out.println(reverse(a));
        System.out.println((1 << 31) - 1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(-1 << 31);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.pow(2147483641, 1 / 31));
    }

    public static int reverse(int x) {
        int activeQuotient = ((1 << 31) - 1) / 10;
        int activeRemainder = ((1 << 31) - 1) % 10;
        int negitiveQuotient = (-1 << 31) / 10;
        int negitiveRemainder = (-1 << 31) % 10;
        int result = 0;

        if (x > 0) {
            // 正数
            for (int i = x % 10; x >= 1; x = x / 10, i = x % 10) {
                if (result > activeQuotient || (result == activeQuotient && i > activeRemainder)) {
                    // 判断溢出
                    return 0;
                }
                result = result * 10 + i;
            }
        } else {
            for (int i = x % 10; x <= -1; x = x / 10, i = x % 10) {
                if (result < negitiveQuotient || (result == negitiveQuotient && i < negitiveRemainder)) {
                    return 0;
                }
                result = result * 10 + i;
            }
        }
        return result;
    }
}
