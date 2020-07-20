import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 228. 汇总区间.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/20
 */
public class SummaryRanges228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (stack.isEmpty()) {
                stack.add(num);
            } else {
                if (num - stack.peek() != 1) {
                    String str = String.valueOf(stack.pop());
                    if (!stack.isEmpty()) {
                        int start = stack.pop();
                        while (!stack.isEmpty()) {
                            start = stack.pop();
                        }
                        str = start + "->" + str;
                    }
                    result.add(str);

                }
                stack.add(num);
            }
        }
        if (!stack.isEmpty()) {
            String str = String.valueOf(stack.pop());
            if (!stack.isEmpty()) {
                int start = stack.pop();
                while (!stack.isEmpty()) {
                    start = stack.pop();
                }
                str = start + "->" + str;
            }
            result.add(str);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483647,2147483647};
        System.out.println(new SummaryRanges228().summaryRanges(nums));
    }
}
