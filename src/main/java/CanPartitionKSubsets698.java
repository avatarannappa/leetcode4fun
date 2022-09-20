import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * medium
 *
 * @author avatarannappa
 * @date 2022/9/20
 */
public class CanPartitionKSubsets698 {

    int[] nums;
    int k;
    int target;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 贪心，回溯
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        this.nums = nums;
        this.k = k;
        this.target = (int) (total / k);
        return recursion(nums.length - 1, 0, 0, new boolean[nums.length]);
    }

    public boolean recursion(int end, int sum, int count, boolean[] visited) {
        if (count == k) {
            return true;
        }
        if (end == -1) {
            return false;
        }
        if (sum == target) {
            return recursion(nums.length - 1, 0, count + 1, visited);
        }
        
        for (int i = end; i >= 0; i--) {
            if (visited[i] || sum + nums[i] > target) {
                continue;
            }
            visited[i] = true;
            if (recursion(i - 1, sum + nums[i], count, visited)) {
                return true;
            }
            visited[i] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 4, 6, 2, 3, 8, 10, 2, 10, 7};
        int k = 4;
        // true
        System.out.println(new CanPartitionKSubsets698().canPartitionKSubsets(nums, k));
    }
}
