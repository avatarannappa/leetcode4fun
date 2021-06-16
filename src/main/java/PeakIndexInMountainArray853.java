/**
 * 852. 山脉数组的峰顶索引
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/16
 */
public class PeakIndexInMountainArray853 {

    public int peakIndexInMountainArray(int[] arr) {
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

    public static void main(String[] args) {
        int[] arr = {1, 10, 5, 1};
        System.out.println(new PeakIndexInMountainArray853().peakIndexInMountainArray(arr));
    }
}
