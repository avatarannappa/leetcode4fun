import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 174. 地下城游戏.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/4
 */
public class CalculateMinimumHP174 {

    int[][] dungeon;
    int h;
    int w;
    int[][] memo;

    public int calculateMinimumHP(int[][] dungeon) {
        // 超时
        this.dungeon = dungeon;
        h = dungeon.length;
        w = dungeon[0].length;
        memo = new int[h][w];
        return dfs(0, 0) + 1;
    }

    public int dfs(int i, int j) {
        if (i == h - 1 && j == w - 1) {
            return Math.max(-dungeon[i][j], 0);
        }
        // 如果memo数组中有值，直接取出并返回，不进行后续的搜索。
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int minRes = 0;
        if (j == w - 1) {
            minRes = Math.max(dfs(i + 1, j) - dungeon[i][j], 0);
        } else if (i == h - 1) {
            minRes = Math.max(dfs(i, j + 1) - dungeon[i][j], 0);
        } else {
            minRes = Math.max(Math.min(dfs(i + 1, j), dfs(i, j + 1)) - dungeon[i][j], 0);
        }

        return memo[i][j] = minRes;
    }

    Queue<Integer> globalQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    Map<String, Integer> cache = new HashMap<>();

    public int calculateMinimumHPOld(int[][] dungeon) {
        // 超时
        this.dungeon = dungeon;
        h = dungeon.length;
        w = dungeon[0].length;
        Queue<Integer> edgeQueue = new PriorityQueue<>();
        globalQueue.offer(-2000000000);

        dfsOld(0, 0, 0, edgeQueue);
        int max = globalQueue.peek();
        return max > 0 ? 1 : -max + 1;
    }

    public void dfsOld(int i, int j, int edge, Queue<Integer> edgeQueue) {
        edge += dungeon[i][j];
        if (edge < globalQueue.peek()) {
            return;
        }
        edgeQueue.add(edge);
        if (i == h - 1 && j == w - 1) {
            globalQueue.offer(edgeQueue.peek());
        }
        if (i < h - 1) {
            dfsOld(i + 1, j, edge, edgeQueue);
        }
        if (j < w - 1) {
            dfsOld(i, j + 1, edge, edgeQueue);
        }
        edgeQueue.remove(edge);
    }

    public static void main(String[] args) {
        // int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int[][] dungeon = {{100}};
        System.out.println(new CalculateMinimumHP174().calculateMinimumHP(dungeon));
    }
}
