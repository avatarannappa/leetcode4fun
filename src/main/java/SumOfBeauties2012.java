/**
 * 2012. 数组美丽值求和.
 * medium
 *
 * @author avatarannappa
 * @version 2025/3/11
 */
public class SumOfBeauties2012 {

    public int sumOfBeauties(int[] nums) {
        // 前缀最大，后缀最小
        int n = nums.length;
        int res = 0;
        
        int[] prev = new int[n];
        prev[0] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            prev[i] = Math.max(nums[i], prev[i - 1]);
        }
        int[] post = new int[n];
        post[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            post[i] = Math.min(nums[i], post[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > prev[i - 1] && nums[i] < post[i + 1]) {
                res += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                res += 1;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        // 2
        System.out.println(new SumOfBeauties2012().sumOfBeauties(nums));
    }
}
