/**
 * 1052. 爱生气的书店老板.
 * medium
 *
 * @author avatarannappa
 * @date 2024/4/23
 */
public class MaxSatisfied1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // 双前缀和
        // TODO 滑动窗口
        int n = customers.length;
        int[] origin = new int[n + 1];
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            origin[i + 1] = grumpy[i] == 1 ? origin[i] : origin[i] + customers[i];
            preSum[i + 1] = preSum[i] + customers[i];
        }
        if (minutes >= n) {
            return preSum[n];
        }
        int diff = 0;
        for (int i = 0; i < n - minutes + 1; i++) {
            int r = i + minutes;
            diff = Math.max(diff, (preSum[r] - preSum[i]) - (origin[r] - origin[i]));
        }
        return origin[n] + diff;
    }

    public static void main(String[] args) {
        int[] customers = {4, 10, 10};
        int[] grumpy = {1, 1, 0};
        int minutes = 2;
        // 24
        System.out.println(new MaxSatisfied1052().maxSatisfied(customers, grumpy, minutes));
    }
}
