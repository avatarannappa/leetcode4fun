import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. 子集
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/14
 */
public class Subsets78 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        recursion(0, nums, new ArrayList<>());
        return result;
    }

    public void recursion(int start, int[] nums, List<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            recursion(i + 1, nums, list);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        List<List<Integer>> result = new Subsets78().subsets(nums);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

}
