/**
 * 643. 子数组最大平均数I. 
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/19
 */
public class FindMaxAverage643I {
    public double findMaxAverage(int[] nums, int k) {
        // 前缀和
        double max = Integer.MIN_VALUE;
        double[] sumArray = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sumArray[i + 1] = sumArray[i] + nums[i];
        }
        for (int i = 0; i + k <= nums.length; i++) {
            max = Math.max(max, (sumArray[i + k] - sumArray[i]) / k);
        }
        return max;
    }
}
