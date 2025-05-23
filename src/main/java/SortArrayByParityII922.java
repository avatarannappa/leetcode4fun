/**
 * 922. 按奇偶排序数组 II
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2025/5/23
 */
public class SortArrayByParityII922 {

    public int[] sortArrayByParityII(int[] nums) {
        // TODO 空间复杂度O(1),使用双指针
        int n = nums.length;
        int even = 0;
        int odd = 0;

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                while (even < n && nums[even] % 2 == 1) {
                    even++;
                }
                res[i] = nums[even++];
            } else {
                while (odd < n && nums[odd] % 2 == 0) {
                    odd++;
                }
                res[i] = nums[odd++];
            }
        }
        return res;
    }

}
