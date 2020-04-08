import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/8
 */
public class DailyTemperatures739 {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < T[i]) {
                int count = stack.peek()[2] + 1;
                int[] b = stack.pop();
                result[b[1]] = count;
                if (!stack.isEmpty()) {
                    stack.peek()[2] += count;
                }
            }
            int[] a = new int[3];
            a[0] = T[i];
            a[1] = i;
            stack.push(a);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new DailyTemperatures739().dailyTemperatures(T)));
    }
}
