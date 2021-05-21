import java.util.Arrays;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/21
 */
public class ReversePairsOffer51 {

    int count = 0;

    public int reversePairs(int[] nums) {
        recursion(nums);
        return count;
    }

    public int[] recursion(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // 分
        int mid = nums.length / 2;
        int[] left = recursion(Arrays.copyOfRange(nums, 0, mid));
        int[] right = recursion(Arrays.copyOfRange(nums, mid, nums.length));
        // 合
        int i = 0;
        int j = 0;
        int[] result = new int[nums.length];
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                result[k] = right[j];
                count += left.length - i;
                j++;
            } else {
                result[k] = left[i];
                i++;
            }
            k++;
        }
        if (i < left.length) {
            while (i < left.length) {
                result[k] = left[i];
                i++;
                k++;
            }
        }
        if (j < right.length) {
            while (j < right.length) {
                result[k] = right[j];
                j++;
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        // 5
        // int[] nums = {2, 3, 5, 7, 1, 4, 6, 8};
        // 7
        System.out.println(new ReversePairsOffer51().reversePairs(nums));
    }
}
