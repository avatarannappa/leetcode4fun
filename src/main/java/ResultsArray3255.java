import java.util.Arrays;

/**
 * 3255. 长度为 K 的子数组的能量值 II.
 * medium
 *
 * @author avatarannappa
 * @version 2024/11/7
 */
public class ResultsArray3255 {

    public int[] resultsArray(int[] nums, int k) {
        // 滑动窗口，模拟
        if (k == 1) {
            return nums;
        }
        int i = 0;
        int j = 1;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int m = res.length;

        boolean pre = false;
        while (i < m && j < n) {
            if (pre) {
                if (nums[j] - nums[j - 1] == 1) {
                    res[i] = nums[j];
                    i++;
                    j++;
                } else {
                    while (i < m && i < j) {
                        res[i++] = -1;
                    }
                    j++;
                    pre = false;
                }
            } else {
                while (j - i < k && nums[j] - nums[j - 1] == 1) {
                    j++;
                }
                if (j - i == k) {
                    pre = true;
                    res[i] = nums[j - 1];
                    i++;
                } else {
                    while (i < m && i < j) {
                        res[i++] = -1;
                    }
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 7, 12, 8, 13, 4, 8, 9, 41, 42, 43, 9, 11, 6, 10, 8, 2, 3, 4, 11, 4, 8};
        int k = 3;
        // 输出：[-1,-1,7,-1,-1,-1,-1,-1,-1,-1,-1,43,-1,-1,-1,-1,-1,-1,-1,4,-1,-1,-1]
        System.out.println(Arrays.toString(new ResultsArray3255().resultsArray(nums, k)));
    }
}
