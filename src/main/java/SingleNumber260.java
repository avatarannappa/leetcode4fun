import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 260. 只出现一次的数字 III.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/16
 */
public class SingleNumber260 {

    public int[] singleNumber(int[] nums) {
        int mask = 0;
        for (int num : nums) {
            mask ^= num;
        }

        int x = 0;
        int diff = mask & (-mask);
        for (int num : nums) {
            if ((diff & num) == 0) {
                x ^= num;
            }
        }
        return new int[]{x, mask ^ x};
    }

    public int[] singleNumberOld(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return nums;
        }
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] result = new int[2];
        int i = 0;
        for (Integer integer : set) {
            result[i] = integer;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 3, 4, 1};
        System.out.println(Arrays.toString(new SingleNumber260().singleNumber(nums)));
    }
}
