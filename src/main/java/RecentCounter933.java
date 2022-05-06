import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 933. 最近的请求次数.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/5/6
 */
public class RecentCounter933 {

    int count;
    Deque<Integer> requests = new ArrayDeque<>();

    public RecentCounter933() {
        count = 0;
    }

    public int ping(int t) {
        requests.add(t);
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }
        return requests.size();
    }

}
