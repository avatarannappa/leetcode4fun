/**
 * 287. 寻找重复数.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/18
 */
public class FindDuplicate287 {

    public int findDuplicate(int[] nums) {
        int[] mask = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            mask[nums[i] - 1] += 1;
        }
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] > 1) {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 4, 2};
        System.out.println(new FindDuplicate287().findDuplicate(nums));
    }
}
