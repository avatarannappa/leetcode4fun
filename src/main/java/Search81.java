/**
 * 81. 搜索旋转排序数组 II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/3
 */
public class Search81 {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return recursion(nums, 0, nums.length - 1, target);
    }

    public boolean recursion(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (nums[m] == target) {
                return true;
            } else if (target < nums[m]) {
                if (nums[m] < nums[r]) {
                    r = m - 1;
                } else {
                    return recursion(nums, l, m - 1, target) || recursion(nums, m + 1, r, target);
                }
            } else {
                if (nums[m] > nums[l]) {
                    l = m + 1;
                } else {
                    return recursion(nums, l, m - 1, target) || recursion(nums, m + 1, r, target);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 1};
        int target = 1;
        System.out.println(new Search81().search(nums, target));
    }
}
