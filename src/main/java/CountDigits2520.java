/**
 * 2520. 统计能整除数字的位数
 * easy
 *
 * @author avatarannappa
 * @date 2023/10/26
 */
public class CountDigits2520 {

    public int countDigits(int num) {
        int ans = 0;

        int temp = num;
        while (temp > 0) {
            int val = temp % 10;
            if (num % val == 0) {
                ans++;
            }
            temp = temp / 10;
        }

        return ans;
    }
}
