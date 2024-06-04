import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3067. 在带权树网络中统计可连接服务器对数目
 * medium
 *
 * @author avatarannappa
 * @date 2024/6/4
 */
public class CountPairsOfConnectableServers3067 {

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        // 根枚举+乘法原理
        int n = edges.length + 1;
        int[] res = new int[n];

        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            List<int[]> list1 = graph[edge[0]];
            int[] arr1 = new int[2];
            arr1[0] = edge[1];
            arr1[1] = edge[2];
            list1.add(arr1);
            List<int[]> list2 = graph[edge[1]];
            int[] arr2 = new int[2];
            arr2[0] = edge[0];
            arr2[1] = edge[2];
            list2.add(arr2);
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            if (graph[i].size() < 2) {
                continue;
            }
            int pre = 0;
            for (int[] ints : graph[i]) {
                int t = bfs(graph, ints[0], visited, ints[1], signalSpeed);
                res[i] += pre * t;
                pre += t;
            }
        }

        return res;
    }

    public int bfs(List<int[]>[] graph, int now, Set<Integer> visited, int len, int signalSpeed) {
        if (visited.contains(now)) {
            return 0;
        }
        visited.add(now);
        int res = 0;
        if (len % signalSpeed == 0) {
            res++;
        }
        for (int[] edge : graph[now]) {
            res += bfs(graph, edge[0], visited, len + edge[1], signalSpeed);
        }
        return res;
    }

    public static void main(String[] args) {
        // 输出：[2,0,0,0,0,0,2]
        int[][] edges = {{0, 1, 2}, {0, 2, 3}, {0, 3, 1}};
        int signalSpeed = 1;
        System.out.println(Arrays.toString(new CountPairsOfConnectableServers3067().countPairsOfConnectableServers(edges, signalSpeed)));
    }
}
