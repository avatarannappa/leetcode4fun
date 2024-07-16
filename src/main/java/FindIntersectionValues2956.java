import java.util.HashSet;
import java.util.Set;

/**
 * 2956. 找到两个数组中的公共元素
 * easy
 *
 * @author avatarannappa
 * @date 2024/7/16
 */
public class FindIntersectionValues2956 {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        // 简单模拟
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        int[] res = new int[2];

        for (int i : nums1) {
            if (set2.contains(i)) {
                res[0]++;
            }
        }

        for (int i : nums2) {
            if (set1.contains(i)) {
                res[1]++;
            }
        }

        return res;
    }

}
