/**
 * 540. 有序数组中的单一元素
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/5
 */
public class SingleNonDuplicate540 {

    public int singleNonDuplicate(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(new SingleNonDuplicate540().singleNonDuplicate(nums));
    }
}
