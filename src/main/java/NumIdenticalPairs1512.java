/**
 * 1512. 好数对的数目.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/19
 */
public class NumIdenticalPairs1512 {

    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(new NumIdenticalPairs1512().numIdenticalPairs(nums));
    }
}
