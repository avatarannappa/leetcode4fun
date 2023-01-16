import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * 310. 最小高度树
 * medium
 *
 * @author avatarannappa
 * @date 2023/1/16
 */
public class FindMinHeightTrees310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 证明：根是树最远两点的中间点，根节点：偶数长度，两种根节点可能，奇数长度，一个根节点
        // 找距离最远的两点算法，BFS or DFS
        // TODO DFS or 拓扑排序 or 动态规划
        // link 543.树的直径
        List<Integer> ans = new ArrayList<Integer>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int x = findLongestNode(0, parent, adj);
        int y = findLongestNode(x, parent, adj);
        List<Integer> path = new ArrayList<>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if ((m & 1) == 0) {
            ans.add(path.get(m / 2 - 1));
        }
        ans.add(path.get(m / 2));
        return ans;
    }

    public int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
        // 找到距离u最远的点，BFS
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(u);

        boolean[] visit = new boolean[adj.length];
        visit[u] = true;
        int node = -1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            node = cur;
            for (int t : adj[cur]) {
                if (!visit[t]) {
                    visit[t] = true;
                    parent[t] = cur;
                    queue.offer(t);
                }
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(new FindMinHeightTrees310().findMinHeightTrees(n, edges));
    }
}
