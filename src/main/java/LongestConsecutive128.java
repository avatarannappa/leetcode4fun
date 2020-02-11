import java.util.Arrays;

/**
 * 128. 最长连续序列.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/9
 */
public class LongestConsecutive128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        Arrays.sort(nums);
        int longest = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                temp++;
            } else if (nums[i] - nums[i - 1] == 0) {
                continue;
            } else {
                if (temp > longest) {
                    longest = temp;
                }
                temp = 1;
            }
        }
        if (temp > longest) {
            longest = temp;
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7};
        System.out.println(new LongestConsecutive128().longestConsecutive(nums));
    }
}
