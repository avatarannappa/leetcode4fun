import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/30
 */
public class NextGreaterElements503 {

    public int[] nextGreaterElements(int[] nums) {
        // 单调栈，两次循环
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int item = stack.peek();
                if (nums[i] < item) {
                    res[i] = item;
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int item = stack.peek();
                if (nums[i] < item) {
                    res[i] = item;
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(new NextGreaterElements503().nextGreaterElements(nums)));
    }
}
