/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/13
 */
public class SearchOffer53I {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                count++;
                l = mid - 1;
                r = mid + 1;
                while (l >= 0) {
                    if (nums[l] != target) {
                        break;
                    }
                    l--;
                    count++;
                }
                while (r < nums.length) {
                    if (nums[r] != target) {
                        break;
                    }
                    r++;
                    count++;
                }
                return count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(new SearchOffer53I().search(nums, target));
    }
}
