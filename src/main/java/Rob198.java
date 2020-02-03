import java.util.Arrays;

/**
 * 198. 打家劫舍
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/3
 */
public class Rob198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int a = nums[0];
            int b = nums[1];
            int event = a;
            int odd = Math.max(a, b);
            // 可以再简化不分奇偶，不想写了
            for (int i = 2; i < nums.length; i++) {
                if (i % 2 == 0) {
                    event = Math.max(event + nums[i], odd);
                } else {
                    odd = Math.max(odd + nums[i], event);
                }

            }
            return Math.max(event, odd);
        }
    }

    public int robRecursion(int[] nums) {
        // 超出时间限制
        // [226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,
        // 49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,
        // 192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,
        // 37,169,225,54,103,55,166,124]
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int a = nums[0];
            int b = nums[1];
            int aNext = robRecursion(Arrays.copyOfRange(nums, 2, nums.length));
            int bNext = 0;
            if (nums.length > 3) {
                bNext = robRecursion(Arrays.copyOfRange(nums, 3, nums.length));
            }
            return Math.max(a + aNext, b + bNext);
        }
    }

    public static void main(String[] args) {
        // int[] nums = {2, 7, 9, 3, 1};
        // 12
        int[] nums =
                {226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191, 68, 206, 23,
                        225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55, 209, 18, 55, 122, 65, 66,
                        177, 101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138, 212, 192, 125, 77, 223, 188,
                        99, 228, 90, 25, 193, 211, 84, 239, 119, 234, 85, 83, 123, 120, 131, 203, 219, 10, 82, 35, 120,
                        180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124};
        // 7102
        // int[] nums = {2, 1, 1, 2};
        // 4
        // int[] nums = {1,2,3,1};
        // 4
        System.out.println(new Rob198().rob(nums));
    }
}
