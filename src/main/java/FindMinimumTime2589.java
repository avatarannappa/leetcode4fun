import java.util.Arrays;

/**
 * 2589. 完成所有任务的最少时间
 * hard
 *
 * @author avatarannappa
 * @date 2024/5/15
 */
public class FindMinimumTime2589 {

    public int findMinimumTime(int[][] tasks) {
        // 贪心
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int n = tasks.length;
        int res = 0;
        int maxEnd = tasks[n - 1][1];
        boolean[] done = new boolean[maxEnd + 1];
        for (int i = 0; i < n; i++) {
            int start = tasks[i][0];
            int end = tasks[i][1];
            int time = tasks[i][2];
            for (int j = start; j <= end; j++) {
                if (done[j]) {
                    time--;
                }
            }
            for (int j = end; time > 0; j--) {
                if (!done[j]) {
                    done[j] = true;
                    time--;
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] tasks = {{2, 3, 1}, {4, 5, 1}, {1, 5, 2}};
        // 2
        System.out.println(new FindMinimumTime2589().findMinimumTime(tasks));
    }
}
