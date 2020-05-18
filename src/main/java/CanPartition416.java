/**
 * 416. 分割等和子集.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/18
 */
public class CanPartition416 {

    private int[] nums;

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum >>= 1;
        this.nums = nums;
        return recursion(nums.length - 1, sum, sum);
    }

    public boolean recursion(int index, int a, int b) {
        if (a == 0 || b == 0) {
            return true;
        } else if (a < 0 || b < 0) {
            return false;
        } else {
            return recursion(index - 1, a - nums[index], b) || recursion(index - 1, a, b - nums[index]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(new CanPartition416().canPartition(nums));
    }
}
