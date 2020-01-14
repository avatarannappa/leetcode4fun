/**
 * 29. 两数相除
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/26
 */
public class Divide29 {

    public int divide(int dividend, int divisor) {
        // 1ms
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean flag = true; //true +, false -
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = false;
        }
        if (dividend > 0) {
            dividend = negative(dividend);
        }
        if (divisor > 0) {
            divisor = negative(divisor);
        }
        if (dividend > divisor) {
            return 0;
        }
        int ans = 1;
        int tempDivisor = divisor;
        while ((dividend <= divisor + divisor) && (divisor + divisor < 0)) {
            divisor = divisor + divisor;
            ans = ans + ans;
        }

        if (dividend - divisor != 0) {
            ans = ans + divide(dividend - divisor, tempDivisor);
        }

        if (flag) {
            return ans;
        } else {
            return negative(ans);
        }
    }

    public int divide2ms(int dividend, int divisor) {
        // 2ms
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean flag = true; //true +, false -
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = false;
        }
        if (dividend > 0) {
            dividend = negative(dividend);
        }
        if (divisor > 0) {
            divisor = negative(divisor);
        }
        if (dividend > divisor) {
            return 0;
        }
        int ans = 1;
        int newDividend = dividend;
        int tempDivisor = divisor;
        while (dividend <= divisor && divisor<0) {
            newDividend = dividend - divisor;
            divisor += divisor;
            if (dividend <= divisor && divisor<0) {
                ans = ans + ans;
            }
        }

        if (newDividend != 0) {
            ans = ans + divide(newDividend, tempDivisor);
        }

        if (flag) {
            return ans;
        } else {
            return negative(ans);
        }
    }

    public int divideOld(int dividend, int divisor) {
        // 超时
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean flag = true; //true +, false -
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = false;
        }
        if (dividend > 0) {
            dividend = negative(dividend);
        }
        if (divisor > 0) {
            divisor = negative(divisor);
        }
        int result = 0;
        while (dividend <= 0) {
            dividend -= divisor;
            result++;
        }
        result--;
        if (flag) {
            return result;
        } else {
            return negative(result);
        }
    }

    private int negative(int n) {
        return ~n + 1;
    }

    public int divideMy(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        return dividend / divisor;
    }

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 1;
        System.out.println(new Divide29().divide(dividend, divisor));

    }
}
