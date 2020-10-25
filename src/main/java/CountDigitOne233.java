/**
 * 233. 数字 1 的个数
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/24
 */
public class CountDigitOne233 {

    public int countDigitOne(int n) {
        int result = 0;
        for (int i = 1; i <= n; i *= 10) {
            result += (n / (i * 10)) * i + Math.min(i, Math.max(0, n % (i * 10) - i + 1));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountDigitOne233().countDigitOne(13));
    }

}
