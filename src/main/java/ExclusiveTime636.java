import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 636. 函数的独占时间
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/7
 */
public class ExclusiveTime636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        // 栈，记录执行中间被插入时间
        int[] ans = new int[n];

        Stack<Fun> stack = new Stack<>();
        for (String log : logs) {
            Fun fun = new Fun(log);
            if (fun.start) {
                stack.push(fun);
            } else {
                Fun funStart = stack.pop();
                int oneTime = fun.time - funStart.time + 1 - funStart.gap;
                ans[fun.num] += oneTime;
                if (!stack.isEmpty()) {
                    stack.peek().gap += funStart.gap + oneTime;
                }
            }
        }

        return ans;
    }

    public static class Fun {
        public int num;
        public boolean start;
        public int time;
        public int gap;

        public Fun(String log) {
            String[] arr = log.split(":");
            num = Integer.parseInt(arr[0]);
            start = arr[1].equals("start");
            time = Integer.parseInt(arr[2]);
            gap = 0;
        }
    }

    public static void main(String[] args) {
//        int n = 1;
//        List<String> logs = List.of("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");
//        // 8
//        System.out.println(Arrays.toString(new ExclusiveTime636().exclusiveTime(n, logs)));
    }
}
