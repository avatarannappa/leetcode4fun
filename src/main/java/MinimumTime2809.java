import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2809. 使数组和小于等于 x 的最少时间
 * hard
 *
 * @author avatarannappa
 * @date 2024/1/19
 */
public class MinimumTime2809 {

    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        // 贪心+DP
        int n = nums1.size();
        int[][] arr = new int[n][2];
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums1.get(i);
            arr[i][1] = nums2.get(i);
            s1 += arr[i][0];
            s2 += arr[i][1];
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));

        // 用 dp[j][i] 表示如果对前 j 个元素进行 i 次操作，可以减少的最大总值，初始值为零。对于第 j 个元素，我们可以选择对其进行操作或者不操作
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            int a = arr[j - 1][0];
            int b = arr[j - 1][1];
            for (int i = 1; i <= j; i++) {
                dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - 1] + i * b + a);
            }
        }

        for (int i = 0; i <= n; i++) {
            if (s1 + s2 * i - dp[n][i] <= x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(1, 2, 3);
        // 3
        System.out.println(new MinimumTime2809().minimumTime(nums1, nums2, 4));
    }
}
