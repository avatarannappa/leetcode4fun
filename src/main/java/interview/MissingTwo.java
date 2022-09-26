package interview;

import java.util.Arrays;

/**
 * 面试题 17.19. 消失的两个数字
 * hard
 *
 * @author avatarannappa
 * @date 2022/9/26
 */
public class MissingTwo {

    public int[] missingTwo(int[] nums) {
        // O(N) 时间内只用 O(1) 的空间
        // TODO 异或，思想类似，分成两组
        int n = nums.length + 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int twoSum = (n + 1) * n / 2 - sum;
        int mid = twoSum / 2;
        int tempSum = 0;
        for (int num : nums) {
            if (num <= mid) {
                tempSum += num;
            }
        }
        int[] ans = new int[2];
        ans[0] = mid * (mid + 1) / 2 - tempSum;
        ans[1] = twoSum - ans[0];
        return ans;
    }

    public int[] missingTwoOld(int[] nums) {
        // O(N) 时间内只用 O(N) 的空间
        int[] mask = new int[30010];
        int[] ans = new int[2];

        for (int num : nums) {
            mask[num] = num;
        }
        for (int i = 1; i < mask.length; i++) {
            if (mask[i] == 0) {
                if (ans[0] == 0) {
                    ans[0] = i;
                } else if (ans[1] == 0) {
                    ans[1] = i;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3};
        // 1, 4
        System.out.println(Arrays.toString(new MissingTwo().missingTwo(nums)));
    }
}
