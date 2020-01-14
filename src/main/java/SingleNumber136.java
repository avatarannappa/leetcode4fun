/**
 * 136. 只出现一次的数字.
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/19
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i : nums) {
            num = num ^ i;
        }
        return num;
    }

    public static void main(String[] args) {
        SingleNumber136 singleNumber136 = new SingleNumber136();
        int[] nums = {4, 1, 2, 1, 2};
        int result = singleNumber136.singleNumber(nums);
        System.out.println(result);
    }
}
