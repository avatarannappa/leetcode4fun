import java.util.Arrays;

/**
 * 66. 加一
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/11
 */
public class PlusOne66 {

    public int[] plusOne(int[] digits) {

        boolean sign = true;
        int count = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (sign) {
                int x = (digits[i] + 1) / 10;
                int y = (digits[i] + 1) % 10;
                if (x == 0) {
                    sign = false;
                } else {
                    count++;
                }
                digits[i] = y;
            }
        }
        if (count == digits.length) {
            int[] result = new int[digits.length + 1];
            for (int i = digits.length - 1; i >= 0; i--) {
                result[i + 1] = digits[i];
            }
            result[0] = 1;
            return result;
        } else {
            int[] result = digits;
            return result;
        }

    }

    public int[] plusOneOther(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits; // 不进位就结束
        }
        digits = new int[digits.length + 1]; // 初始化默认0
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        PlusOne66 plusOne66 = new PlusOne66();
        int[] param = {9, 9, 9};
        int[] result = plusOne66.plusOne(param);
        System.out.println(Arrays.toString(result));
    }
}
