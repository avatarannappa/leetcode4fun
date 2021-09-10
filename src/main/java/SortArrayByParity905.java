import java.util.Arrays;

/**
 * 905. 按奇偶排序数组 easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/10
 */
public class SortArrayByParity905 {

    public int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[l++] = num;
            } else {
                res[r--] = num;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2};
        System.out.println(Arrays.toString(new SortArrayByParity905().sortArrayByParity(nums)));
    }
}