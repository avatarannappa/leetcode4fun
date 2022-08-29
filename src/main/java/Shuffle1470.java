import java.util.Arrays;

/**
 * 1470. 重新排列数组
 * easy
 *
 * @author avatarannappa
 * @date 2022/8/29
 */
public class Shuffle1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];

        int index = 0;
        for (int i = 0, j = n; i < n; i++, j++) {
            ans[index++] = nums[i];
            ans[index++] = nums[j];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};
        int n = 4;
        // Output: [1,4,2,3,3,2,4,1]
        System.out.println(Arrays.toString(new Shuffle1470().shuffle(nums, n)));
    }
}
