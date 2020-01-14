import java.util.Arrays;

/**
 * 75. 颜色分类
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/13
 */
public class SortColors75 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int p0 = 0;
        int p2 = nums.length - 1;
        int cur = 0;
        while (cur < nums.length && cur <= p2) {
            if (nums[cur] == 0) {
                if (cur != p0) {
                    nums[cur] = nums[p0];
                    nums[p0] = 0;
                }
                cur++;
                p0++;
            } else if (nums[cur] == 2) {
                nums[cur] = nums[p2];
                nums[p2] = 2;
                p2--;
            } else {
                cur++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new SortColors75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
