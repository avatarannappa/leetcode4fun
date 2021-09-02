import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 743. 网络延迟时间 medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/2
 */
public class NetworkDelayTime743 {

    static int INTMAX = 0x3f3f3f3f;

    /* BFS */
    public int networkDelayTime(int[][] times, int n, int k) {
        // 建图 - 邻接表
        Map<Integer, Map<Integer, Integer>> mp = new HashMap<>();
        for (int[] edg : times) {
            if (!mp.containsKey(edg[0])) {
                mp.put(edg[0], new HashMap<>());
            }
            mp.get(edg[0]).put(edg[1], edg[2]);
        }
        // 记录结点最早收到信号的时间 
        int[] r = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            r[i] = INTMAX;
        }
        r[k] = 0;

        // 队列中存放 [结点，收到信号时间]
        Deque<int[]> s = new ArrayDeque<>();
        s.addLast(new int[]{k, 0});

        while (!s.isEmpty()) {
            int[] cur = s.pollFirst();
            if (mp.containsKey(cur[0])) {
                for (int v : mp.get(cur[0]).keySet()) {
                    int t = mp.get(cur[0]).get(v) + cur[1];
                    if (t < r[v]) {
                        r[v] = t;
                        s.addLast(new int[]{v, t});
                    }
                }
            }
        }

        int minT = -1;
        for (int i = 1; i <= n; ++i) {
            minT = Math.max(minT, r[i]);
        }
        return minT == INTMAX ? -1 : minT;
    }

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        System.out.println(new NetworkDelayTime743().networkDelayTime(times, n, k));
    }

}
