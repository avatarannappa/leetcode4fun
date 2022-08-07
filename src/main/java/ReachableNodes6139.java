import java.util.*;

/**
 * 6139. 受限条件下可到达节点的数目
 * 2022.08.07 周赛
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/7
 */
public class ReachableNodes6139 {

    public int reachableNodesOld(int n, int[][] edges, int[] restricted) {
        // 用例59超時
        List<int[]> list = new LinkedList<>();
        for (int[] edge : edges) {
            Arrays.sort(edge);
            list.add(edge);
        }
        list.sort((o1, o2) -> o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0]);

        Set<Integer> set = new HashSet<>();
        for (int i : restricted) {
            set.add(i);
        }

        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        int ans = 1;

        while (!queue.isEmpty()) {
            List<Integer> tempList = new LinkedList<>();
            while (!queue.isEmpty()) {
                int now = queue.poll();
                List<int[]> indexList = new LinkedList<>();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i)[0] == now && !set.contains(list.get(i)[1])) {
                        tempList.add(list.get(i)[1]);
                        indexList.add(list.get(i));
                        ans++;
                    }
                    if (list.get(i)[1] == now && !set.contains(list.get(i)[0])) {
                        tempList.add(list.get(i)[0]);
                        indexList.add(list.get(i));
                        ans++;
                    }
                    if (list.get(i)[0] > now && list.get(i)[1] > now) {
                        break;
                    }
                }
                for (int[] arr : indexList) {
                    list.remove(arr);
                }

            }
            queue.addAll(tempList);
        }
        return ans;
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // 构造树
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> rev = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> l = map.getOrDefault(edge[0], new LinkedList<>());
            l.add(edge[1]);
            map.put(edge[0], l);

            List<Integer> rl = rev.getOrDefault(edge[1], new LinkedList<>());
            rl.add(edge[0]);
            rev.put(edge[1], rl);
        }

        Set<Integer> visited = new HashSet<>();
        TreeNode root = new TreeNode(0);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<TreeNode> tempList = new LinkedList<>();
            while (!deque.isEmpty()) {
                List<TreeNode> childs = new LinkedList<>();
                TreeNode now = deque.poll();
                int i = now.val;
                List<Integer> l = map.getOrDefault(i, new LinkedList<>());
                map.remove(i);
                List<Integer> rl = rev.getOrDefault(i, new LinkedList<>());
                rev.remove(i);
                l.addAll(rl);
                l.removeAll(visited);
                visited.add(now.val);
                for (Integer integer : l) {
                    TreeNode node = new TreeNode(integer);
                    childs.add(node);
                    tempList.add(node);
                }
                now.childs = childs;
            }
            deque.addAll(tempList);
        }

        Set<Integer> set = new HashSet<>();
        for (int i : restricted) {
            set.add(i);
        }

        int ans = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<TreeNode> tempList = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode now = queue.poll();
                if (!set.contains(now.val)) {
                    ans++;
                    tempList.addAll(now.childs);
                }
            }
            queue.addAll(tempList);
        }

        return ans;
    }

    public static class TreeNode {
        public int val;
        public List<TreeNode> childs;

        TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] edges = {{4, 1}, {1, 3}, {1, 5}, {0, 5}, {3, 6}, {8, 4}, {5, 7}, {6, 9}, {3, 2}};
        int[] restricted = {2, 7};
        System.out.println(new ReachableNodes6139().reachableNodes(n, edges, restricted));
    }

}
