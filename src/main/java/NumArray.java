/**
 * 303. 区域和检索 - 数组不可变.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/25
 */
public class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int count = 0;
        for (; i <= j; i++) {
            count += nums[i];
        }
        return count;
    }

}
