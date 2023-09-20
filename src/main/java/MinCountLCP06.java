/**
 * LCP 06. 拿硬币
 * easy
 *
 * @author avatarannappa
 * @date 2023/9/20
 */
public class MinCountLCP06 {

    public int minCount(int[] coins) {
        // 简单模拟
        int ans = 0;

        for (int coin : coins) {
            ans += (coin + 1) / 2;
        }

        return ans;
    }
}
