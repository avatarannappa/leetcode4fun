import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 805. 数组的均值分割
 * hard
 *
 * @author avatarannappa
 * @date 2022/11/14
 */
public class SplitArraySameAverage805 {

    boolean ans;
    Map<Integer, Integer> map = new HashMap<>();

    public boolean splitArraySameAverage(int[] nums) {
        // 递归二分写法
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - sum;
        }
        recursion(nums, 0, n / 2, 0, 0);
        recursion(nums, n / 2, n, 0, 0);
        return ans;
    }

    public void recursion(int[] nums, int i, int lim, int sum, int cnt) {
        if (i <= nums.length / 2) {
            // 前一半存表
            map.put(sum, cnt);
        }
        if (i > nums.length / 2
            && map.containsKey(-sum)
            && map.get(-sum) + cnt != 0
            && map.get(-sum) + cnt != nums.length) {
            // 集合没数据，或者集合等于全集则不包括
            // 后一半查表
            ans = true;
        }
        if (ans) {
            return;
        } else if (i < lim) {
            // 背包问题，选与不选
            recursion(nums, i + 1, lim, sum + nums[i], cnt + 1);
            recursion(nums, i + 1, lim, sum, cnt);
        }
    }

    public boolean splitArraySameAverageOld(int[] nums) {
        // 用位表示选or不选，数学等式，二分减少时间复杂度到2**(n/2)
        // 如果用递归的方法写可能容易理解
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length;
        int m = n / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - sum;
        }

        Set<Integer> left = new HashSet<>();
        for (int i = 1; i < (1 << m); i++) {
            // 2**m 种情况
            int tot = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    // 选不选j
                    tot += nums[j];
                }
            }
            if (tot == 0) {
                // tot == 0 && 总的avg == 0 则 剩余集合的tot肯定也为0
                return true;
            }
            // 缓存，供相反数查表
            left.add(tot);
        }
        int rsum = 0;
        for (int i = m; i < n; i++) {
            rsum += nums[i];
        }
        for (int i = 1; i < (1 << (n - m)); i++) {
            int tot = 0;
            for (int j = m; j < n; j++) {
                if ((i & (1 << (j - m))) != 0) {
                    tot += nums[j];
                }
            }
            if (tot == 0 || (rsum != tot && left.contains(-tot))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        // 输入: nums = [1,2,3,4,5,6,7,8]
        // 输出: true
        // 解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
        System.out.println(new SplitArraySameAverage805().splitArraySameAverage(nums));
    }
}
