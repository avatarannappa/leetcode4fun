/**
 * 507. 完美数.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/9
 */
public class CheckPerfectNumber507 {

    public static void main(String[] args) {
        // 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
        // 28 = 1 + 2 + 4 + 7 + 14
        System.out.println(new CheckPerfectNumber507().checkPerfectNumber(28));
    }

    public boolean checkPerfectNumber(int num) {
        if (num < 3) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return num == sum;
    }
}
