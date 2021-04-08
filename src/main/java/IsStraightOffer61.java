import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/8
 */
public class IsStraightOffer61 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                if (nums[i + 1] == nums[i]) {
                    return false;
                } else {
                    temp += nums[i + 1] - nums[i];
                }
            }
        }
        return temp <= 4;
    }

    public static void main(String[] args) {
        int[] nums = {11, 0, 9, 0, 0};
        System.out.println(new IsStraightOffer61().isStraight(nums));
    }
}
