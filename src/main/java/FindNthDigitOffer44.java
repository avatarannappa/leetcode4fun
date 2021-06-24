/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * medium
 * 同400
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/24
 */
public class FindNthDigitOffer44 {

    public int findNthDigit(int n) {
        int i = 1;
        while (n > i * 9 * Math.pow(10, i - 1)) {
            n = (int) (n - i * 9 * Math.pow(10, i - 1));
            i++;
        }
        int num = (n - 1) / i + (int) Math.pow(10, i - 1);
        String s = String.valueOf(num);
        return s.charAt((n - 1) % i) - '0';
    }

    public static void main(String[] args) {
        int n = 666;
        // 8
        System.out.println(new FindNthDigitOffer44().findNthDigit(n));
    }
}
