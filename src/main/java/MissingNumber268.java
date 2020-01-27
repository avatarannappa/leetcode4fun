/**
 * 268. 缺失数字
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/27
 */
public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        int[] mask = new int[nums.length + 1];
        for (int num : nums) {
            mask[num] = 1;
        }
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(new MissingNumber268().missingNumber(nums));
    }
}
