import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 1630. 等差子数组
 * medium
 *
 * @author avatarannappa
 * @date 2023/3/23
 */
public class CheckArithmeticSubarrays1630 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new LinkedList<>();

        for (int i = 0; i < l.length; i++) {
            int start = l[i];
            int end = r[i];
            int[] arr = new int[end - start + 1];
            System.arraycopy(nums, start, arr, 0, end - start + 1);
            ans.add(check(arr));
        }

        return ans;
    }

    public boolean check(int[] arr) {
        Arrays.sort(arr);
        int g = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != g) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 5, 9, 3, 7}, l = {0, 0, 2}, r = {2, 3, 5};
        System.out.println(new CheckArithmeticSubarrays1630().checkArithmeticSubarrays(nums, l, r));
    }
}
