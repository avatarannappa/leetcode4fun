/**
 * 137. 只出现一次的数字II
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/9
 */
public class SingleNumber137 {

    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        for (int num : nums) {
            one = ~two & (one ^ num);
            two = ~one & (two ^ num);
        }
        return one;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(new SingleNumber137().singleNumber(nums));
    }
}
