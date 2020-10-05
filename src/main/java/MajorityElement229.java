import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 229. 求众数 II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/5
 */
public class MajorityElement229 {

    public List<Integer> majorityElement(int[] nums) {
        // 摩尔投票法
        // https://leetcode-cn.com/problems/majority-element-ii/solution/liang-fu-dong-hua-yan-shi-mo-er-tou-piao-fa
        // -zui-zh/
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int threshold = nums.length / 3;
        for (int num : nums) {
            if (!set.contains(num)) {
                int count = map.getOrDefault(num, 0);
                if (count + 1 > threshold) {
                    set.add(num);
                    result.add(num);
                }
                map.put(num, count + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(new MajorityElement229().majorityElement(nums));
    }

}
