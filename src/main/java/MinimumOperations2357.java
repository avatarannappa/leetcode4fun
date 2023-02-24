import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2357. 使数组中所有元素都等于零
 * easy
 *
 * @author avatarannappa
 * @date 2023/2/24
 */
public class MinimumOperations2357 {

    public int minimumOperations(int[] nums) {
        // nlogn，排序+模拟
        Arrays.sort(nums);
        int ans = 0;
        int num = 0;
        for (int i : nums) {
            int gap = i - num;
            if (gap == 0) {
                continue;
            }
            num += gap;
            ans++;
        }

        return ans;
    }

    public int minimumOperationsNew(int[] nums) {
        // n
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (i != 0) {
                set.add(i);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 3, 5};
        System.out.println(new MinimumOperations2357().minimumOperations(nums));
    }
}
