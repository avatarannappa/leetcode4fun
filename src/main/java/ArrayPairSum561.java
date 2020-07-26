import java.util.Arrays;

/**
 * 561. 数组拆分 I
 *
 * @author avatarannappa
 * @version 1.0, 2020/07/26
 */
public class ArrayPairSum561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
