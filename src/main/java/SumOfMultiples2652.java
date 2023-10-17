/**
 * 2652. 倍数求和
 * easy
 *
 * @author avatarannappa
 * @date 2023/10/17
 */
public class SumOfMultiples2652 {

    public int sumOfMultiples(int n) {
        // 简单模拟
        int ans = 0;

        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0) {
                ans += i;
            } else if (i % 5 == 0) {
                ans += i;
            } else if (i % 7 == 0) {
                ans += i;
            }
        }

        return ans;
    }
}
