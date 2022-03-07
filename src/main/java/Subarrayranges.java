/**
 * 2104. 子数组范围和.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/3/4
 */
public class Subarrayranges {

    public long subArrayRangesTODO(int[] nums) {
        // TODO 单调栈 O(n)
        return 0;
    }
    
    public long subArrayRanges(int[] nums) {
        // 区间DP变种，直接记录区间内最大最小，参与结果计算。不用保存每次最大最小值。O(n^^2)
        if (nums == null || nums.length < 2) {
            return 0;
        }

        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                ans += max - min;
            }
        }

        return ans;
    }

    public long subArrayRangesOld(int[] nums) {
        // 暴力，超时 O(n^^3)
        if (nums == null || nums.length < 2) {
            return 0;
        }

        long ans = 0;
        int len = 2;
        while (len <= nums.length) {
            for (int i = 0; i < nums.length - len + 1; i++) {
                long max = nums[i];
                long min = nums[i];
                for (int j = i; j < i + len; j++) {
                    max = Math.max(max, nums[j]);
                    min = Math.min(min, nums[j]);
                }
                ans += max - min;
            }
            len++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, -2, -3, 4, 1};
        // 59
        System.out.println(new Subarrayranges().subArrayRanges(nums));
    }

}
