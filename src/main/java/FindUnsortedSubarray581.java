import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/2
 */
public class FindUnsortedSubarray581 {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] sortNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortNums);
        int l = 0;
        int r = nums.length - 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sortNums[i]) {
                count++;
            } else {
                break;
            }
        }

        if (count < nums.length - 1) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] == sortNums[j]) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(new FindUnsortedSubarray581().findUnsortedSubarray(nums));
    }
}
