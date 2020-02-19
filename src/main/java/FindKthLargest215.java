import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/20
 */
public class FindKthLargest215 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(new FindKthLargest215().findKthLargest(nums, k));
    }
}
