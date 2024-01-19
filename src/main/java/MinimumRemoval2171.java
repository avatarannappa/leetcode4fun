import java.util.Arrays;

/**
 * 2171. 拿出最少数目的魔法豆
 * medium
 *
 * @author avatarannappa
 * @date 2024/1/18
 */
public class MinimumRemoval2171 {

    public long minimumRemoval(int[] beans) {
        // 规律 数学 前缀和
        Arrays.sort(beans);
        int n = beans.length;
        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = beans[i - 1] + preSum[i - 1];
        }

        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long bean = beans[i];
            long left = preSum[i];
            long right = preSum[n] - bean * (n - i);
            min = Math.min(min, Math.max(left, right));
        }
        return min;
    }

    public static void main(String[] args) {
        int[] beans = {4, 1, 6, 5};
        // 4
        System.out.println(new MinimumRemoval2171().minimumRemoval(beans));
    }
}
