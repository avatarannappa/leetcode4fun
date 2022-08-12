/**
 * 410. 分割数组的最大值
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/12
 */
public class SplitArray410 {

    public int splitArray(int[] nums, int m) {
        // 二分，另一个角度思考 sum 导致 m + 1 才能完成分割的边界点
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int l = max;
        int r = sum;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int temp = split(nums, mid);
            if (temp > m) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int split(int[] nums, int target) {
        // 需要分成几份，才能保证 sum <= target
        // 因为都是正数且区间连续，循环一遍 nums 就行了
        int split = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num > target) {
                sum = 0;
                split++;
            }
            sum += num;
        }
        return split;
    }

    public static void main(String[] args) {
        int[] nums = {1, 100, 2, 3, 4};
        int m = 3;
        // 100
        System.out.println(new SplitArray410().splitArray(nums, m));
    }
}
