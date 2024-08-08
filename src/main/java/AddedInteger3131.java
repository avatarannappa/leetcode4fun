/**
 * 3131. 找出与数组相加的整数 I
 * easy
 *
 * @author avatarannappa
 * @date 2024/8/8
 */
public class AddedInteger3131 {

    public int addedInteger(int[] nums1, int[] nums2) {
        // 对比最小的差，O(n)。不需要考虑数组合理性
        int a = nums1[0];
        int b = nums2[0];
        for (int i = 1; i < nums1.length; i++) {
            a = Math.min(a, nums1[i]);
            b = Math.min(b, nums2[i]);
        }
        return b - a;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 6, 4};
        int[] nums2 = {9, 7, 5};
        // 输出：3
        System.out.println(new AddedInteger3131().addedInteger(nums1, nums2));
    }
}
