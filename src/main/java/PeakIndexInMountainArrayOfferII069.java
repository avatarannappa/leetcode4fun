/**
 * 剑指 Offer II 069. 山峰数组的顶部 easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/10/21
 */
public class PeakIndexInMountainArrayOfferII069 {

    public int peakIndexInMountainArray(int[] arr) {
        // 同852，二分极值
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else if (arr[mid] < arr[mid - 1]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
