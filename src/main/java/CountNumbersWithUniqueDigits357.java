/**
 * 357. 计算各个位数不同的数字个数
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/4
 */
public class CountNumbersWithUniqueDigits357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        } else if (n == 2) {
            return 91;
        }
        n = Math.min(n, 10);
        int result = 91;
        for (int i = 3; i <= n; i++) {
            int temp = 9;
            for (int j = 0; j < i - 1; j++) {
                temp *= 9 - j;
            }
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new CountNumbersWithUniqueDigits357().countNumbersWithUniqueDigits(n));
    }
}
