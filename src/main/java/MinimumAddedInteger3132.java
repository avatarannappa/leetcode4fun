import java.util.Arrays;

/**
 * 3132. 找出与数组相加的整数 II
 * medium
 *
 * @author avatarannappa
 * @date 2024/8/9
 */
public class MinimumAddedInteger3132 {

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        // 排序+枚举(规律)，O(nlogn)
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            int t = nums2[0] - nums1[i];
            int notMatchCount = i;
            for (int j = 1, k = i + 1; j < nums2.length && k < nums1.length; ) {
                if (notMatchCount > 2) {
                    break;
                }
                if (nums2[j] - nums1[k] == t) {
                    j++;
                    k++;
                } else {
                    notMatchCount++;
                    k++;
                }
            }
            if (notMatchCount <= 2) {
                res = Math.min(res, t);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {7, 2, 6, 8, 7};
        int[] nums2 = {7, 6, 5};
        //
        //输出：-1
        System.out.println(new MinimumAddedInteger3132().minimumAddedInteger(nums1, nums2));
    }
}
