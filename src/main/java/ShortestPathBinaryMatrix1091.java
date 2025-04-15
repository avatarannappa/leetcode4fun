import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1091. 二进制矩阵中的最短路径.
 * medium
 *
 * @author avatarannappa
 * @version 2025/4/15
 */
public class ShortestPathBinaryMatrix1091 {

    // 8个方向
    int[][] arrow = {{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        // BFS
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        if (grid[0][0] == 1) {
            return -1;
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        int res = 0;
        while (!q.isEmpty()) {
            List<int[]> tempList = new LinkedList<>();
            res++;
            while (!q.isEmpty()) {
                int[] point = q.poll();
                if (point[0] == m - 1 && point[1] == n - 1) {
                    return res;
                }
                for (int[] arr : arrow) {
                    int ii = point[0] + arr[0];
                    int jj = point[1] + arr[1];
                    if (ii >= 0 && ii < m && jj >= 0 && jj < n && grid[ii][jj] == 0 && visited[ii][jj] == 0) {
                        tempList.add(new int[]{ii, jj});
                        visited[ii][jj] = 1;
                    }
                }
            }

            q.addAll(tempList);
        }
        return -1;
    }

}
