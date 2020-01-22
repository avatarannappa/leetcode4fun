import java.util.Arrays;

/**
 * 16. 最接近的三数之和.
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/5
 */
public class ThreeSumClosest16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int temp = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - temp) < Math.abs(target - sum)) {
                    sum = temp;
                }
                if (temp > target) {
                    end--;
                } else if (temp < target) {
                    start++;
                } else {
                    return temp;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        int target = 82;
        System.out.println(new ThreeSumClosest16().threeSumClosest(nums, target));
    }
}
