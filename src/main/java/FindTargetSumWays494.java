/**
 * 494. 目标和.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/12
 */
public class FindTargetSumWays494 {

    int count = 0;
    int S;
    int[] nums;
    int[] mask;

    public int findTargetSumWays(int[] nums, int S) {
        this.nums = nums;
        this.S = S;
        mask = new int[nums.length];
        int temp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            mask[i] = temp + nums[i];
            temp = mask[i];
        }
        recursion(0, 0);
        return count;
    }

    public void recursion(int sum, int index) {
        if (nums.length == index) {
            if (sum == S) {
                count++;
            }
            return;
        }
        if (sum + mask[index] < S || sum - mask[index] > S) {
            return;
        }
        recursion(sum + nums[index], index + 1);
        recursion(sum - nums[index], index + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(new FindTargetSumWays494().findTargetSumWays(nums, S));
    }
}
