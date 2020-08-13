import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 90. 子集 II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/13
 */
public class SubsetsWithDup90 {

    List<List<Integer>> result = new ArrayList<>();
    Set<String> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        recursion(0, nums, new ArrayList<>());
        return result;
    }

    public void recursion(int start, int[] nums, List<Integer> list) {
        if (!exist(list)) {
            result.add(new ArrayList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            recursion(i + 1, nums, list);
            list.remove(list.size() - 1);
        }

    }

    public boolean exist(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        String s = sb.toString();
        if (set.contains(s)) {
            return true;
        } else {
            set.add(s);
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new SubsetsWithDup90().subsetsWithDup(nums));
    }
}
