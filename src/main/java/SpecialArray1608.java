import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/9/12
 */
public class SpecialArray1608 {

    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int r = n;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= n) {
                return n;
            } else {
                n--;
                if (nums[i] >= n) {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 7, 7, 0};
        // 2
        System.out.println(new SpecialArray1608().specialArray(nums));
    }
}
