import java.util.Arrays;

/**
 * 453. 最小移动次数使数组元素相等.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/1
 */
public class MinMoves453 {

    public int minMoves(int[] nums) {
        // nlogn
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] - nums[0];
        }
        return count;
    }

    public int minMovesNew(int[] nums) {
        // n
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i];
            min = Math.min(min, nums[i]);
        }
        return moves - min * nums.length;
    }

}
