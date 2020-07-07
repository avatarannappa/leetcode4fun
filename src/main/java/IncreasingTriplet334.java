/**
 * 334. 递增的三元子序列.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/7
 */
public class IncreasingTriplet334 {

    public boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= one) {
                one = num;
            } else if (num <= two) {
                two = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 1};
        System.out.println(new IncreasingTriplet334().increasingTriplet(nums));
    }
}
