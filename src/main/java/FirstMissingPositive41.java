/**
 * 41. 缺失的第一个正数
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/2
 */
public class FirstMissingPositive41 {

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int[] mask = new int[length];
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num > 0) {
                if (num <= length) {
                    mask[num - 1] = num;
                }
            }
        }
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == 0) {
                return i + 1;
            }
        }
        return length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {7,8,9,10,11};
        System.out.println(new FirstMissingPositive41().firstMissingPositive(nums));
    }

}
