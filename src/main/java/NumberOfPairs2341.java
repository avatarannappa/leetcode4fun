import java.util.Arrays;

/**
 * 2341. 数组能形成多少数对
 * easy
 *
 * @author avatarannappa
 * @date 2023/2/16
 */
public class NumberOfPairs2341 {

    public int[] numberOfPairs(int[] nums) {
        int[] ans = new int[2];
        int[] mask = new int[110];
        for (int num : nums) {
            mask[num]++;
        }
        for (int i : mask) {
            ans[0] += i / 2;
        }
        ans[1] = nums.length - ans[0] * 2;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 1, 3, 2, 2};
        // [3, 1] 形成3个数对，剩下1个数字
        System.out.println(Arrays.toString(new NumberOfPairs2341().numberOfPairs(nums)));
    }
}
