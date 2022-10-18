/**
 * 902. 最大为 N 的数字组合
 * hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/10/18
 */
public class AtMostNGivenDigitSet902 {

    public int atMostNGivenDigitSet(String[] digits, int n) {
        // 数学
        // TODO 数位DP
        int len = digits.length;
        String nStr = String.valueOf(n);
        int m = nStr.length();

        int ans = 0;

        // 计算小于位数n的组合数
        for (int i = 1; i < m; i++) {
            ans += Math.pow(len, i);
        }

        // 计算等于位数n的组合数
        int temp = recursion(digits, nStr);

        return ans + temp;
    }

    private int recursion(String[] digits, String nStr) {
        int ans = 0;
        if (nStr.length() == 0) {
            return 1;
        }

        int small = 0;
        int equal = 0;
        for (int j = 0; j < digits.length; j++) {
            if (digits[j].charAt(0) < nStr.charAt(0)) {
                small++;
            } else if (digits[j].charAt(0) == nStr.charAt(0)) {
                equal++;
            } else {
                break;
            }
        }

        ans += small * Math.pow(digits.length, nStr.length() - 1);
        if (equal != 0) {
            ans += recursion(digits, nStr.substring(1));
        }

        return ans;
    }

    public static void main(String[] args) {
        // 输入：digits = ["1","3","5","7"], n = 100
        // 输出：20
        // 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
        String[] digits = {"1", "3", "5", "7"};
        int n = 7531;
        // 313
        System.out.println(new AtMostNGivenDigitSet902().atMostNGivenDigitSet(digits, n));
    }
}
