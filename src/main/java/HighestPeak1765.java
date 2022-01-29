import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1765. 地图中的最高点
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/29
 */
public class HighestPeak1765 {

    public int[][] highestPeak(int[][] isWater) {
        // 多源BFS
        int m = isWater.length;
        int n = isWater[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] mask = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                isWater[i][j] ^= 1;
                if (isWater[i][j] == 0) {
                    int[] item = new int[2];
                    item[0] = i;
                    item[1] = j;
                    visited[i][j] = true;
                    queue.add(item);
                }
            }
        }

        while (!queue.isEmpty()) {
            List<int[]> tempList = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] item = queue.pop();

                int now = isWater[item[0]][item[1]];
                for (int k = 0; k < 4; k++) {
                    int nx = item[0] + mask[k][0];
                    int ny = item[1] + mask[k][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (isWater[nx][ny] != 0 && !visited[nx][ny]) {
                            isWater[nx][ny] = now + 1;
                            visited[nx][ny] = true;
                            tempList.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            queue.addAll(tempList);
        }

        return isWater;
    }

    public int[][] highestPeakOld(int[][] isWater) {
        // 模拟，case50超时
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] mask = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean end = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                isWater[i][j] ^= 1;
            }
        }

        while (!end) {
            end = true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int min = isWater[i][j];
                    if (min == 0) {
                        continue;
                    }
                    for (int k = 0; k < 4; k++) {
                        if (i + mask[k][0] >= 0
                            && i + mask[k][0] < m
                            && j + mask[k][1] >= 0
                            && j + mask[k][1] < n) {
                            min = Math.min(min, isWater[i + mask[k][0]][j + mask[k][1]]);
                        }
                    }
                    if (min == isWater[i][j]) {
                        end = false;
                        isWater[i][j] = min + 1;
                    }
                }
            }
        }

        return isWater;
    }

    public static void main(String[] args) {
        int[][] isWater = {{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
        int[][] ans = new HighestPeak1765().highestPeak(isWater);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }
}
