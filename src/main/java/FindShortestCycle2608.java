import java.util.*;

import utils.Array2ListUtil;

/**
 * 2608. 图中的最短环.
 * hard
 *
 * @author avatarannappa
 * @version 2025/3/30
 */
public class FindShortestCycle2608 {
    private List<Integer>[] g;
    private int[] dis; // dis[i] 表示从 start 到 i 的最短路长度

    public int findShortestCycle(int n, int[][] edges) {
        // BFS：从点 a 到 点 b. 有两条简单路径。两条路径组成了一个环。
        // 本身BFS是贪心，正确性证明略
        this.g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            // 建图。邻接表
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        dis = new int[n];

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) // 枚举每个起点跑 BFS
            ans = Math.min(ans, bfs(i));
        return ans < Integer.MAX_VALUE ? ans : -1;
    }

    private int bfs(int start) {
        int ans = Integer.MAX_VALUE;
        Arrays.fill(dis, -1);
        dis[start] = 0;
        // 0 当前节点，1 父节点
        Deque<int[]> q = new ArrayDeque<int[]>();
        q.add(new int[] { start, -1 });
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int parent = p[1];
            for (int y : g[x])
                if (dis[y] < 0) { // 第一次遇到
                    dis[y] = dis[x] + 1;
                    q.add(new int[] { y, x });
                } else if (y != parent) // 第二次遇到
                    ans = Math.min(ans, dis[x] + dis[y] + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindShortestCycle2608 solution = new FindShortestCycle2608();
        int[][] edges = Array2ListUtil
                .convertToPrimitive2d(Array2ListUtil.string2Int2DArray("[[4,1],[5,1],[3,2],[5,0],[4,0],[3,0],[2,1]]"));
        int n = 6;
        System.out.println(solution.findShortestCycle(n, edges)); // Output: 3
    }

}
