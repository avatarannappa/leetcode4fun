/**
 * 2272. 最大波动的子字符串
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2025/3/16
 */
public class LargestVariance2272 {

    public int largestVariance(String s) {
        char[] arr = s.toCharArray();
        int ans = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (i == j) {
                    continue;
                }
                int sum = 0;
                // 只有 i 和 j 都出现了sum结果才有效
                int sumWithJ = Integer.MIN_VALUE;

                for (char c : arr) {
                    // 参考：53. 最大子数组和
                    if (c == i) {
                        sum = Math.max(sum, 0) + 1;
                        sumWithJ++;
                    } else if (c == j) {
                        sum = Math.max(sum, 0) - 1;
                        sumWithJ = sum;
                    }
                    ans = Math.max(ans, sumWithJ);
                }
            }
        }
        return ans;
    }

}
