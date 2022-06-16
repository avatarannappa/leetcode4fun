import java.util.Arrays;

/**
 * 532. 数组中的 k-diff 数对
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/6/16
 */
public class FindPairs532 {

    public int findPairs(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int pre = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (pre == nums[i]) {
                continue;
            }
            if (nums[nums.length - 1] - nums[i] < k) {
                continue;
            }
            pre = nums[i];
            int j = i + 1;
            while (j < nums.length) {
                int temp = nums[j] - nums[i];

                if (temp == k) {
                    ans++;
                    break;
                } else if (temp > k) {
                    break;
                }
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4, 3, 3, 0, 9, 2, 3};
        int k = 3;
        // 2
        System.out.println(new FindPairs532().findPairs(nums, k));
    }
    }
