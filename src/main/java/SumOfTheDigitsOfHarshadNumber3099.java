/**
 * 3099. 哈沙德数
 * easy
 *
 * @author avatarannappa
 * @date 2024/7/3
 */
public class SumOfTheDigitsOfHarshadNumber3099 {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        // 简单模拟
        int res = 0;
        int t = x;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        if (t % res == 0) {
            return res;
        }
        return -1;
    }

}
