/**
 * 88. 合并两个有序数组
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/17
 */
public class Merge88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        int[] merge = new int[m + n];

        for (int i = 0; i < merge.length; i++) {
            if (index1 >= m) {
                merge[i] = nums2[index2++];
            } else if (index2 >= n) {
                merge[i] = nums1[index1++];
            } else {
                if (nums1[index1] > nums2[index2]) {
                    merge[i] = nums2[index2++];
                } else {
                    merge[i] = nums1[index1++];
                }
            }
        }

        System.arraycopy(merge, 0, nums1, 0, merge.length);
    }

}
