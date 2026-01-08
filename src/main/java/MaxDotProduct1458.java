import java.util.Arrays;

/**
 * 1458. 两个子序列的最大点积.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2026/1/8
 */
public class MaxDotProduct1458 {

    int[][] mem;
    int[] a;
    int[] b;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        // 递归 + 记忆
        mem = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            Arrays.fill(mem[i], Integer.MAX_VALUE);
        }
        a = nums1;
        b = nums2;
        return dp(nums1.length - 1, nums2.length - 1);
    }

    public int dp(int i, int j) {
        if (i == -1 || j == -1) {
            return Integer.MIN_VALUE;
        }
        if (mem[i][j] != Integer.MAX_VALUE) {
            return mem[i][j];
        }
        int chooseBoth = Math.max(0, dp(i - 1, j - 1)) + a[i] * b[j];
        int noA = dp(i - 1, j);
        int noB = dp(i, j - 1);
        mem[i][j] = Math.max(chooseBoth, Math.max(noA, noB));
        return mem[i][j];
    }

    public int maxDotProductIteration(int[] nums1, int[] nums2) {
        // 递推
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i < nums1.length + 1; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], Math.max(dp[i][j], 0) + nums1[i] * nums2[j]);
            }
        }
        return dp[nums1.length][nums2.length];
    }

    public static void main(String[] args) {
        // 18
        int[] nums1 = {2, 1, -2, 5};
        int[] nums2 = {3, 0, -6};
        System.out.println(new MaxDotProduct1458().maxDotProductIteration(nums1, nums2));

    }
}
