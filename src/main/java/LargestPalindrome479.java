/**
 * 479. 最大回文数乘积.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2022/4/16
 */
public class LargestPalindrome479 {

    public int largestPalindrome(int n) {
        // 超时
        if (n == 1) {
            return 9;
        }
        int max = (int) Math.pow(10, n) - 1;
        int min = (int) (Math.pow(10, n - 1));
        for (int i = max; i >= min; i--) {
            long num = i, t = i;
            while (t != 0) {
                num = num * 10 + (t % 10);
                t /= 10;
            }
            System.out.println(num);
            for (long j = max; j * j >= num; j--) {
                if (num % j == 0) {
                    return (int) (num % 1337);
                }
            }
        }
        return 0;
    }

    public int largestPalindromeOld(int n) {
        // 超时
        if (n == 1) {
            return 9;
        }
        int max = (int) Math.pow(10, n) - 1;
        int min = (int) (Math.pow(10, n - 1));
        // 注意max * max不行
        long i = (long) Math.pow(max, 2);
        for (; i >= min * min; i--) {
            if (isPalindrome(i)) {
                for (int j = max; j >= max / 2; j--) {
                    if (i % j == 0 && i / j >= min && i / j <= max) {
                        return (int) (i % 1337);
                    }
                }
            }
        }
        return 0;
    }

    private boolean isPalindrome(long num) {
        String str = String.valueOf(num);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LargestPalindrome479 largestPalindrome479 = new LargestPalindrome479();
        // 9966006699
        System.out.println(99999L * 99999L);
        System.out.println(largestPalindrome479.largestPalindrome(5));
    }
}
