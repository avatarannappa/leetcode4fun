import java.util.Arrays;

/**
 * 324. 摆动排序 II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/24
 */
public class WiggleSort324 {

    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        int m = 0;
        int n = 1;
        int mid = (int) Math.ceil(nums.length / 2.0);
        for (int i = 0; i < nums.length; i++) {
            if (m < nums.length) {
                temp[m] = nums[mid - 1 - i];
            }
            if (n < nums.length) {
                temp[n] = nums[nums.length - 1 - i];
            }
            m += 2;
            n += 2;
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4, 2};
        new WiggleSort324().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
