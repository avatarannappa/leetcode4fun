/**
 * 747. 至少是其他数字两倍的最大数.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/1
 */
public class DominantIndex747 {

    public int dominantIndex(int[] nums) {
        int index = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != index && max < nums[i] * 2) {
                return -1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 4};
        System.out.println(new DominantIndex747().dominantIndex(nums));
    }
}
