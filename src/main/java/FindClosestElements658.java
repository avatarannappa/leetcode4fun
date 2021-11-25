import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/25
 */
public class FindClosestElements658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 二分。参考Collections.binarySearch，如果不完全相等返回-left临近index而且是没找到的负号
        List<Integer> result = new ArrayList<>();
        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        } else if (x > arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length; i++) {
                result.add(arr[i]);
            }
            return result;
        }
        int index = findK(arr, x);
        if (index < 0) {
            index = -index;
        }
        int l = Math.max(0, index - k);
        int r = Math.min(index + k, arr.length - 1);
        while (r - l >= k) {
            if (Math.abs(x - arr[l]) <= Math.abs(arr[r] - x)) {
                r--;
            } else {
                l++;
            }
        }
        for (int i = l; i <= r; i++) {
            result.add(arr[i]);
        }
        return result;

    }

    private int findK(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + right >>> 1;
            if (arr[mid] < k) {
                left = mid + 1;
            } else if (arr[mid] > k) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -left;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,10,10,10};
        int k = 1;
        int x = 9;
        // 1,2,3,4
        System.out.println(new FindClosestElements658().findClosestElements(arr, k, x));
    }
}
