import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 407. 接雨水II.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/8
 */
public class TrapRainWaterII407 {

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j, heightMap[i][j]});
                }
            }
        }

        int[][] mask = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = arr[0] + mask[i][0];
                int ny = arr[1] + mask[i][1];
                if (nx > 0 && ny > 0 && nx < m - 1 && ny < n - 1 && !visited[nx][ny]) {
                    if (arr[2] > heightMap[nx][ny]) {
                        ans += arr[2] - heightMap[nx][ny];
                    }
                    queue.offer(new int[]{nx, ny, Math.max(arr[2], heightMap[nx][ny])});
                    visited[nx][ny] = true;
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] heightMap = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        System.out.println(new TrapRainWaterII407().trapRainWater(heightMap));
    }

}
