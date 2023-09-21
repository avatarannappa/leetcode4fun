import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 2603. 收集树中金币
 * hard
 *
 * @author avatarannappa
 * @date 2023/9/21
 */
public class CollectTheCoins2603 {

    public int collectTheCoins(int[] coins, int[][] edges) {
        // 无向无根树，拓扑排序
        int n = coins.length;

        // 构造 邻接表 和 度列表
        Set<Integer> visited = new HashSet<>();

        List<Integer>[] adj = new List[n];
        int[] cnt = new int[n];
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            List<Integer> aList = adj[a] == null ? new ArrayList<>() : adj[a];
            List<Integer> bList = adj[b] == null ? new ArrayList<>() : adj[b];
            aList.add(b);
            adj[a] = aList;
            cnt[a]++;
            bList.add(a);
            adj[b] = bList;
            cnt[b]++;

            visited.add(a);
            visited.add(b);
        }

        // 统计叶子（度为1）
        Deque<Integer> q1 = new ArrayDeque<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 1) {
                q1.addLast(i);
            }
        }

        // 拓扑排序，找到有金币的叶子节点，删除无金币的叶子节点
        Deque<Integer> q2 = new ArrayDeque<>();
        while (!q1.isEmpty()) {
            List<Integer> nextLevel = new LinkedList<>();
            while (!q1.isEmpty()) {
                Integer node = q1.pollFirst();
                if (coins[node] == 1) {
                    q2.add(node);
                    continue;
                }
                visited.remove(node);
                List<Integer> linkedNodes = adj[node];
                if (linkedNodes.isEmpty()) {
                    continue;
                }
                int link = linkedNodes.get(0);
                adj[link].remove(node);
                cnt[link]--;
                if (cnt[link] == 1) {
                    nextLevel.add(link);
                }
            }
            q1.addAll(nextLevel);
        }

        // 拓扑排序，找到需要访问的点，删除叶子结点和父节点
        int i = 0;
        while (!q2.isEmpty() && i < 2) {
            Set<Integer> nextLevel = new HashSet<>();

            while (!q2.isEmpty()) {
                Integer node = q2.pollFirst();
                visited.remove(node);
                List<Integer> linkedNodes = adj[node];
                for (Integer link : linkedNodes) {
                    adj[link].remove(node);
                    cnt[link]--;
                    if (cnt[link] == 1) {
                        nextLevel.add(link);
                    }
                }
            }

            q2.addAll(nextLevel);
            i++;
        }

        return Math.max(0, (visited.size() - 1) * 2);
    }

    public static void main(String[] args) {
        int[] coins = {1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1};
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}, {5, 6}, {6, 7}, {3, 8}, {6, 9}, {7, 10}, {10, 11},
            {10, 12}, {7, 13}, {12, 14}, {13, 15}, {14, 16}, {15, 17}, {10, 18}};
        // 12
        System.out.println(new CollectTheCoins2603().collectTheCoins(coins, edges));
    }
}
