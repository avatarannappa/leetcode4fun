import java.util.Arrays;

/**
 * 2974. 最小数字游戏
 * easy
 *
 * @author avatarannappa
 * @date 2024/7/12
 */
public class NumberGame2974 {

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i += 2) {
            res[i] = nums[i + 1];
            res[i + 1] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 3};
        // 3, 2, 5, 4
        System.out.println(Arrays.toString(new NumberGame2974().numberGame(nums)));
    }
}
