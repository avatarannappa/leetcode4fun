import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 47. 全排列 II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/20
 */
public class PermuteUnique47 {

    Set<String> set = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            return result;
        }
        result = recursion(nums);
        removeDuplicated(result);
        return result;
    }

    public List<List<Integer>> recursion(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            return result;
        }
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int[] newNums = new int[length - 1];
            System.arraycopy(nums, 0, newNums, 0, i);
            if (i < length - 1) {
                System.arraycopy(nums, i + 1, newNums, i, length - i - 1);
            }
            List<List<Integer>> wtf = recursion(newNums);
            for (List<Integer> l : wtf) {
                l.add(num);
                result.add(l);
            }
        }
        return result;
    }

    public void removeDuplicated(List<List<Integer>> wtf) {
        Iterator<List<Integer>> iterator = wtf.iterator();
        while (iterator.hasNext()) {
            List<Integer> tempList = iterator.next();
            StringBuilder sb = new StringBuilder();
            for (Integer integer : tempList) {
                sb.append(integer);
            }
            if (set.contains(sb.toString())) {
                iterator.remove();
            } else {
                set.add(sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new PermuteUnique47().permuteUnique(nums));
    }
}
