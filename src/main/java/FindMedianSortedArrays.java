/**
 * @author avatarannappa
 * @version 1.0, 2018/12/19
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] a1 = {1, 3};
        int[] a2 = {2, 4};
        System.out.println(findMedianSortedArrays(a1, a2));
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] t = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < t.length; i++) {
            if (p1 == nums1.length) {
                t[i] = nums2[p2];
                p2++;
            } else if (p2 == nums2.length) {
                t[i] = nums1[p1];
                p1++;
            } else if (nums1[p1] <= nums2[p2]) {
                t[i] = nums1[p1];
                p1++;
            } else {
                t[i] = nums2[p2];
                p2++;
            }
        }
        if ((t.length % 2) == 0) {
            double left = t[t.length / 2 - 1];
            double right = t[t.length / 2];
            return (left + right) / 2;
        } else {
            return t[t.length / 2];
        }
    }
}
