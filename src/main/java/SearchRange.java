import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * @author avatarannappa
 * @version 1.0, 2019/6/11
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 2, 3};
        int target = 0;
        int[] result = searchRange1(nums, target);
        Arrays.stream(result).forEach(r -> {
            System.out.println(r);
        });
    }

    public static int[] searchRange(int[] nums, int target) {
        // O(n)
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (result[0] == -1) {
                    result[0] = i;
                    result[1] = i;
                } else {
                    result[1] = i;
                }
            }
        }
        return result;
    }

    public static int[] searchRange1(int[] nums, int target) {
        // log(n)
        int[] result = {-1, -1};
        int l = 0;
        int r = nums.length - 1;
        int sign = 0;
        doSearch(nums, target, l, r, result, sign);
        return result;
    }

    public static void doSearch(int[] nums, int target, int l, int r, int[] result, int sign) {
        // log(n)
        if (l > r) {
            return;
        }
        int m = (l + r) / 2;

        if (nums[m] == target) {
            if (sign == 0) {
                result[0] = m;
                result[1] = m;
                doSearch(nums, target, l, m - 1, result, -1);
                doSearch(nums, target, m + 1, r, result, 1);
            } else if (sign < 0) {
                result[0] = m;
                doSearch(nums, target, l, m - 1, result, -1);
            } else if (sign > 0) {
                result[1] = m;
                doSearch(nums, target, m + 1, r, result, 1);
            }

        } else if (nums[(l + r) / 2] > target) {
            doSearch(nums, target, l, m - 1, result, sign);
        } else {
            doSearch(nums, target, m + 1, r, result, sign);
        }
    }
}
