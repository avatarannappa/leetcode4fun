/**
 * 400. 第N个数字.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/24
 */
public class FindNthDigit400 {

    public int findNthDigit(int n) {
        int i = 1;
        while (n > i * (Math.pow(10, i - 1)) * 9) {
            n -= i * (Math.pow(10, i - 1)) * 9;
            i++;
        }
        // 确定区间中数字
        int amNum = (n - 1) / i + (int) Math.pow(10, i - 1);
        // 将数字变为string，好取得确定的数字
        String a = String.valueOf(amNum);
        if (n % i == 0) {
            return a.charAt(i - 1) - '0';
        }
        return a.charAt(n % i - 1) - '0';
    }

    public static void main(String[] args) {
        int n = 365;
        System.out.println(new FindNthDigit400().findNthDigit(n));
    }
}
