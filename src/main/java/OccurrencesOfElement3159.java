import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3159. 查询数组中元素的出现位置.
 * medium
 *
 * @author avatarannappa
 * @version 2024/12/27
 */
public class OccurrencesOfElement3159 {

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                list.add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            int index = queries[i];
            if (index <= list.size()) {
                ans[i] = list.get(index - 1);
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 4, 1};
        int[] queries = {1, 2, 3, 4, 5};
        int x = 1;
        System.out.println(Arrays.toString(new OccurrencesOfElement3159().occurrencesOfElement(nums, queries, x)));
    }
}
