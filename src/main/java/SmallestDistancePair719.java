import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 719. 找出第 K 小的数对距离
 * hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/6/15
 */
public class SmallestDistancePair719 {

    public int smallestDistancePair(int[] nums, int k) {
        // 5% O(N^2)
        int[] array = new int[(int) 1e6 + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                array[Math.abs(nums[i] - nums[j])]++;
            }
        }
        for (int i = 0; ; i++) {
            k -= array[i];
            if (k <= 0) {
                return i;
            }
        }
    }

    public int smallestDistancePairOld(int[] nums, int k) {
        // 超出内存 16/19通过率
        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                l.add(Math.abs(nums[i] - nums[j]));
            }
        }
        l.sort(Comparator.naturalOrder());
        return l.get(k - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 1};
        int k = 3;
        System.out.println(new SmallestDistancePair719().smallestDistancePair(nums, k));
    }
}
