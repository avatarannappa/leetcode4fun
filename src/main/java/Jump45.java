/**
 * 45. 跳跃游戏 II
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/9
 */
public class Jump45 {

    public int jump(int[] nums) {
        int result = 0;

        if (nums == null || nums.length < 2) {
            return 0;
        }

        for (int i = 0; i < nums.length; ) {
            int now = nums[i];
            int max = 0;
            int step = 0;
            for (int j = 1; j <= now; j++) {
                if (i + j >= nums.length - 1) {
                    result++;
                    return result;
                } else {
                    if (i + j + nums[i + j] > max) {
                        max = i + j + nums[i + j];
                        step = j;
                    }
                }
            }
            i += step;
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new Jump45().jump(nums));
    }
}
