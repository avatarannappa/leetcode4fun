import java.util.Arrays;

/**
 * @author avatarannappa
 * @version 1.0, 2019/11/5
 */
public class RemoveDuplicates26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int result = 1;
        int now = 0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                nums[++index] = nums[i];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveDuplicates26 removeDuplicates26 = new RemoveDuplicates26();
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int count = removeDuplicates26.removeDuplicates(nums);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }
}