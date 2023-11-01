import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 2127. 参加会议的最多员工数
 * hard
 *
 * @author avatarannappa
 * @date 2023/11/1
 */
public class MaximumInvitations2127 {

    public int maximumInvitations(int[] favorite) {
        // 内向基环图：拓扑排序+分类讨论
        int n = favorite.length;
        // 出度
        int[] out = new int[n];
        // 入度
        int[] in = new int[n];
        // 反向图
        Map<Integer, List<Integer>> rev = new HashMap<>();
        // 复制
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = favorite[i];
        }

        for (int i = 0; i < favorite.length; i++) {
            int j = favorite[i];
            out[i]++;
            in[j]++;
            List<Integer> l = rev.getOrDefault(j, new LinkedList<>());
            l.add(i);
            rev.put(j, l);
        }

        // 拓扑排序
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int leaf = queue.poll();
                int fav = favorite[leaf];
                favorite[leaf] = -1;
                in[fav]--;
                if (in[fav] == 0) {
                    temp.add(fav);
                }
            }
            queue.addAll(temp);
        }

        // favorite 剪枝后，只有环
        int ans = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (favorite[i] == -1) {
                continue;
            }
            int cycleCount = 0;
            int next = i;
            while (favorite[next] != -1) {
                cycleCount++;
                int j = favorite[next];
                favorite[next] = -1;
                next = j;
            }
            if (cycleCount == 2) {
                rev.get(i).remove(Integer.valueOf(copy[i]));
                rev.get(copy[i]).remove(Integer.valueOf(i));
                res += countTree(i, rev) + countTree(copy[i], rev);
            } else {
                ans = Math.max(ans, cycleCount);
            }
        }
        return Math.max(res, ans);
    }

    public int countTree(int i, Map<Integer, List<Integer>> rev) {
        // 层序遍历
        int level = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(i);
        while (!deque.isEmpty()) {
            level++;
            List<Integer> temp = new LinkedList<>();
            while (!deque.isEmpty()) {
                int node = deque.poll();
                if (rev.containsKey(node)) {
                    temp.addAll(rev.get(node));
                }
            }
            deque.addAll(temp);
        }
        return level;
    }

    public static void main(String[] args) {
        int[] favorite = {1,0,3,2,5,6,7,4,9,8,11,10,11,12,10};
        // 11
        System.out.println(new MaximumInvitations2127().maximumInvitations(favorite));
    }
}
