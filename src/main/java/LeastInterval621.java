import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 621. 任务调度器.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/14
 */
public class LeastInterval621 {

    public int leastInterval(char[] tasks, int n) {
        n++;
        int time = 0;
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int f : map) {
            if (f > 0) {
                queue.add(f);
            }
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int tempN = 0;
            for (int i = 0; i < n; i++) {
                if (!queue.isEmpty()) {
                    tempN++;
                    int temp = queue.poll();
                    if (temp - 1 > 0) {
                        list.add(temp - 1);
                    }
                }
            }
            if (!list.isEmpty()) {
                list.forEach(queue::offer);
            }
            if (queue.isEmpty()) {
                time += tempN;
            } else {
                time += n;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(new LeastInterval621().leastInterval(tasks, n));
    }
}
