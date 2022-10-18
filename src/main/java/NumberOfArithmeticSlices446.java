import java.util.HashMap;
import java.util.Map;

/**
 * 446. 等差数列划分 II - 子序列
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/18
 */
public class NumberOfArithmeticSlices446 {

    public int numberOfArithmeticSlices(int[] nums) {
        // 序列DP
        int ans = 0;
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; i++) {
            f[i] = new HashMap<Long, Integer>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // 输入：nums = [2,4,6,8,10]
        // 输出：7
        // 解释：所有的等差子序列为：
        // [2,4,6]
        // [4,6,8]
        // [6,8,10]
        // [2,4,6,8]
        // [4,6,8,10]
        // [2,4,6,8,10]
        // [2,6,10]
        int[] nums = { 2, 4, 6, 8, 10 };
        System.out.println(new NumberOfArithmeticSlices413().numberOfArithmeticSlices(nums));
    }
    
}
