/**
 * 213. 打家劫舍 II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/8
 */
public class Rob213 {

    int[] nums;

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        this.nums = nums;
        return Math.max(myRob(0, nums.length - 1), myRob(1, nums.length));
    }

    private int myRob(int start, int end) {
        int pre = 0;
        int cur = 0;
        int tmp;
        for (int i = start; i < end; i++) {
            tmp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = tmp;
        }
        return cur;
    }

    int[][] mask;

    public int robOld(int[] nums) {
        this.nums = nums;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        mask = new int[nums.length][nums.length];
        return Math.max(recursion(1, nums.length - 1), recursion(0, nums.length - 2));
    }

    public int recursion(int start, int end) {
        if (mask[start][end] != 0) {
            return mask[start][end];
        }
        // 超时
        if (end - start < 0) {
            return 0;
        }
        if (end - start == 0) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        }
        int max = Math.max(nums[start] + recursion(start + 2, end), recursion(start + 1, end));
        mask[start][end] = max;
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Rob213().rob(nums));
    }
}
