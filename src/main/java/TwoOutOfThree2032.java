import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 2032. 至少在两个数组中出现的值
 * easy
 *
 * @author chenhao138
 * @date 2022/12/29
 */
public class TwoOutOfThree2032 {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new LinkedList<>();

        Set<Integer> set = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                if (ans.contains(i)) {
                    continue;
                }
                ans.add(i);
            }
            set2.add(i);
        }
        set.addAll(set2);

        for (int i : nums3) {
            if (ans.contains(i)) {
                continue;
            }
            if (set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 5, 12, 4, 8, 3, 4, 5, 10}, nums2 = {9, 11, 15, 5}, nums3 = {8};
        // [5, 8]
        System.out.println(new TwoOutOfThree2032().twoOutOfThree(nums1, nums2, nums3));
    }
}
