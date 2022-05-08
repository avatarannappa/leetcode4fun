import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/5/8
 */
public class FindDuplicates442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] mask = new int[nums.length];
        for (int num : nums) {
            int index = num - 1;
            if (mask[index] == 0) {
                mask[index] = 1;
            } else {
                ans.add(num);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindDuplicates442 findDuplicates442 = new FindDuplicates442();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDuplicates442.findDuplicates(nums);
        System.out.println(list);
    }
}
