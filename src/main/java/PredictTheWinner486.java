/**
 * 486. 预测赢家.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/16
 */
public class PredictTheWinner486 {

    int[] nums;

    public boolean PredictTheWinner(int[] nums) {
        this.nums = nums;
        return recursion(0, nums.length - 1) >= 0;
    }

    public int recursion(int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int left = nums[l] - recursion(l + 1, r);
        int right = nums[r] - recursion(l, r - 1);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        System.out.println(new PredictTheWinner486().PredictTheWinner(nums));
    }

}
