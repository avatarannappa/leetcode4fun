/**
 * 1688. 比赛中的配对次数.
 * easy.
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/25
 */
public class NumberOfMatches1688 {

    public int numberOfMatches(int n) {
        // 模拟
        int ans = 0;
        int half = 0;
        while (n > 1) {
            half = n / 2;
            ans += half;
            n = half + n % 2;
        }
        return ans;
    }
}
