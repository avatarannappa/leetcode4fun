import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/15
 */
public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(new ContainsDuplicate217().containsDuplicate(nums));
    }
}
