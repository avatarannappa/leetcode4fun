import java.util.Arrays;

/**
 * 2576. 求出最多标记下标.
 * medium
 *
 * @author avatarannappa
 * @version 2024/9/12
 */
public class MaxNumOfMarkedIndices2576 {

    public int maxNumOfMarkedIndices(int[] nums) {
        // 贪心
        Arrays.sort(nums);
        int l = 0;
        int mid = nums.length / 2;
        int r = mid;
        int ans = 0;

        while (l < r && mid < nums.length) {
            if (nums[l] * 2 <= nums[mid]) {
                ans += 2;
                l++;
            }
            mid++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {57, 40, 57, 51, 90, 51, 68, 100, 24, 39, 11, 85, 2, 22, 67, 29, 74, 82, 10, 96, 14, 35, 25, 76, 26, 54, 29, 44, 63, 49, 73, 50,
                95, 89, 43, 62, 24, 88, 88, 36, 6, 16, 14, 2, 42, 42, 60, 25, 4, 58, 23, 22, 27, 26, 3, 79, 64, 20, 92};
        // 58
        System.out.println(new MaxNumOfMarkedIndices2576().maxNumOfMarkedIndices(nums));
    }
}
