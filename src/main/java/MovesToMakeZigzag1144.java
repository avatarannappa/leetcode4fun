/**
 * 1144. 递减元素使数组呈锯齿状
 * medium
 *
 * @author avatarannappa
 * @date 2023/3/1
 */
public class MovesToMakeZigzag1144 {

    public int movesToMakeZigzag(int[] nums) {
        // 贪心/分类讨论
        if (nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int[] mem = new int[n + 2];
        System.arraycopy(nums, 0, mem, 1, n);
        mem[0] = nums[1];
        mem[n + 1] = nums[n - 2];

        int a = 0;
        int b = 0;
        for (int i = 1; i <= n; i++) {
            int m = Math.min(mem[i - 1], mem[i + 1]);
            if (i % 2 == 0) {
                a += mem[i] < m ? 0 : mem[i] - m + 1;
            } else {
                b += mem[i] < m ? 0 : mem[i] - m + 1;
            }
        }

        return Math.min(a, b);
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 10, 9, 8, 9};
        // 4
        System.out.println(new MovesToMakeZigzag1144().movesToMakeZigzag(nums));
    }
}
