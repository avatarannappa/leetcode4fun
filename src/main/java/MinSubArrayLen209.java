/**
 * 209. 长度最小的子数组
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/26
 */
public class MinSubArrayLen209 {

    public int minSubArrayLen(int s, int[] nums) {
        if (s == 0 || nums == null || nums.length == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                count++;
                if (temp >= s) {
                    if (count < result) {
                        result = count;
                    }
                    break;
                }
                if (i == 0 && j == nums.length - 1) {
                    return 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int s = 3;
        int[] nums = {1, 1};
        System.out.println(new MinSubArrayLen209().minSubArrayLen(s, nums));
    }
}
