import java.util.HashSet;
import java.util.Set;

/**
 * 2367. 算术三元组的数目
 * easy
 *
 * @author avatarannappa
 * @date 2023/3/31
 */
public class ArithmeticTriplets2367 {

    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        int dd = diff * 2;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] + diff) && set.contains(nums[i] + dd)) {
                ans++;
            }
        }

        return ans;
    }

}
