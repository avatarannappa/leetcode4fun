import java.util.Stack;

/**
 * 907. 子数组的最小值之和
 * medium
 * https://leetcode.cn/problems/sum-of-subarray-minimums/description/?envType=daily-question&envId=2023-11-27
 *
 * @author avatarannappa
 * @date 2023/11/27
 */
public class SumSubarrayMins907 {

    public int sumSubarrayMins(int[] arr) {
        // 单调栈+贡献法
        int n = arr.length;
        // 大于arr[i]左边个数
        int[] left = new int[n];
        // 大于arr[i]右边个数
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = i - (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();

        for (int i = arr.length - 1; i >= 0; i--) {
            // 注意这两个条件，前开后闭 或 前闭后开 都行，不然会有重复元素
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? n : stack.peek()) - i;
            stack.push(i);
        }

        int ans = 0;
        int mod = 10_0000_0007;
        for (int i = 0; i < arr.length; i++) {
            ans = (int) ((ans + ((long) arr[i] * left[i] * right[i])) % mod);
        }
        return ans;
    }

    public int sumSubarrayMinsOld(int[] arr) {
        // 超时
        int ans = 0;
        int mod = 10_0000_0007;
        for (int i = 0; i < arr.length; i++) {
            ans = (ans + arr[i]) % mod;
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                temp = Math.min(temp, arr[j]);
                ans = (ans + temp) % mod;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 1};
        // 13
        System.out.println(new SumSubarrayMins907().sumSubarrayMins(arr));
    }
}
