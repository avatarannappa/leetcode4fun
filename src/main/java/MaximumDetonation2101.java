import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 2101. 引爆最多的炸弹
 * medium
 *
 * @author avatarannappa
 * @date 2024/7/22
 */
public class MaximumDetonation2101 {

    public int maximumDetonation(int[][] bombs) {
        // 几何 + 有向图
        int n = bombs.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < bombs.length; i++) {
            for (int j = i + 1; j < bombs.length; j++) {
                if (isConnect(bombs, i, j)) {
                    graph[i].add(j);
                }
                if (isConnect(bombs, j, i)) {
                    graph[j].add(i);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < bombs.length; i++) {
            Set<Integer> visited = new HashSet<>();
            Deque<Integer> queue = new ArrayDeque<>();
            visited.add(i);
            queue.add(i);
            int cnt = 1;
            while (!queue.isEmpty()) {
                List<Integer> tempList = new LinkedList<>();
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    List<Integer> connects = graph[cur];
                    for (Integer connect : connects) {
                        if (!visited.contains(connect)) {
                            tempList.add(connect);
                            visited.add(connect);
                            cnt++;
                        }
                    }
                }
                queue.addAll(tempList);
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

    /**
     * 判断i炸弹是否能引爆j炸弹
     *
     * @param bombs 炸弹数组
     * @param i     炸弹
     * @param j     炸弹
     * @return i 可以引爆 j, 返回true. 注意不可逆.
     */
    public boolean isConnect(int[][] bombs, int i, int j) {
        long x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
        long x2 = bombs[j][0], y2 = bombs[j][1];
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= r1 * r1;
    }

    public static void main(String[] args) {
        int[][] bombs = {{1, 1, 100000}, {100000, 100000, 1}};
        // 输出：2
        System.out.println(new MaximumDetonation2101().maximumDetonation(bombs));
    }
}
