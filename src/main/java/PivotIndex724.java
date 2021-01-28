/**
 * 724. 寻找数组的中心索引
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/1/28
 */
public class PivotIndex724 {

    public int pivotIndex(int[] nums) {
        int[] sum = new int[nums.length];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i] = temp + nums[i];
            temp = sum[i];
        }

        int res = -1;

        for (int i = 0; i < sum.length; i++) {
            if (sum[i] - nums[i] == sum[nums.length-1] - sum[i]) {
                return i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(new PivotIndex724().pivotIndex(nums));
    }
}
