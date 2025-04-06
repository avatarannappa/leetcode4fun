import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/9
 */
public class LongestConsecutive128 {

    public int longestConsecutiveNew(int[] nums) {
        // 哈希表，不排序
        Integer max = Integer.MIN_VALUE;

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            // 不是开始，减少判断
            if (set.contains(num - 1)) {
                continue;
            }
            int cnt = 1;
            while (set.contains(++num)) {
                cnt++;
            }
            max = Math.max(max, cnt);
        }

        return max;
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        Arrays.sort(nums);
        int longest = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                temp++;
            } else if (nums[i] - nums[i - 1] == 0) {
                continue;
            } else {
                if (temp > longest) {
                    longest = temp;
                }
                temp = 1;
            }
        }
        if (temp > longest) {
            longest = temp;
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7};
        System.out.println(new LongestConsecutive128().longestConsecutive(nums));
    }
}
