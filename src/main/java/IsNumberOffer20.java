/**
 * 剑指 Offer 20. 表示数值的字符串.
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2
 * .3"、"+-5"及"12e+5.4"都不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/27
 */
public class IsNumberOffer20 {

    public boolean isNumber(String s) {
        // 同65题
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean isE = false;
        boolean isDot = false;
        boolean isNum = false;
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if ('e' == c) {
                if (isE || !isNum) {
                    return false;
                }
                isE = true;
                isNum = false;
            } else if ('.' == c) {
                if (isDot || isE) {
                    return false;
                }
                isDot = true;
            } else if ('-' == c || '+' == c) {
                if (i != 0 && arr[i - 1] != 'e') {
                    return false;
                }
            } else if (c >= '0' && c <= '9') {
                isNum = true;
            } else {
                return false;
            }
        }
        return isNum;
    }

    public static void main(String[] args) {
        String s = "-1E-16";
        System.out.println(new IsNumberOffer20().isNumber(s));
    }
}
