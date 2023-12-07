
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 1466. 重新规划路线. Reorder Routes to Make All Paths Lead to the City Zero
 * medium
 *
 * @author avatarannappa
 * @date 2023/12/7
 */
public class MinReorder1466 {

    public int minReorder(int n, int[][] connections) {
        int ans = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> revMap = new HashMap<>();
        boolean[] visited = new boolean[connections.length + 1];
        for (int[] connection : connections) {
            List<Integer> list = map.getOrDefault(connection[1], new LinkedList<>());
            list.add(connection[0]);
            map.put(connection[1], list);
            List<Integer> listRev = revMap.getOrDefault(connection[0], new LinkedList<>());
            listRev.add(connection[1]);
            revMap.put(connection[0], listRev);
        }
        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            List<Integer> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                int city = queue.poll();
                if (map.containsKey(city)) {
                    List<Integer> l = map.get(city);
                    for (Integer i : l) {
                        if (visited[i] == false) {
                            next.add(i);
                            visited[i] = true;
                        }
                    }

                }
                if (revMap.containsKey(city)) {
                    List<Integer> l = revMap.get(city);
                    for (Integer i : l) {
                        if (visited[i] == false) {
                            next.add(i);
                            visited[i] = true;
                            ans++;
                        }
                    }
                }
            }
            queue.addAll(next);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] connections = {{4, 3}, {2, 3}, {1, 2}, {1, 0}};
        // 2
        System.out.println(new MinReorder1466().minReorder(n, connections));
    }

}
