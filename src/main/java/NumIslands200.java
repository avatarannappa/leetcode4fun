import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/21
 */
public class NumIslands200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int height = grid.length;
        int width = grid[0].length;
        int[][] visited = new int[height][width];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (visited[i][j] == 0) {
                    char now = grid[i][j];
                    if (now == '1') {
                        count++;
                        visited[i][j] = 1;
                        int[] index = new int[2];
                        index[0] = i;
                        index[1] = j;
                        queue.add(index);
                        while (!queue.isEmpty()) {
                            int[] item = queue.poll();
                            if (item[1] + 1 < width && grid[item[0]][item[1] + 1] == '1' &&
                                visited[item[0]][item[1] + 1] == 0) {
                                // 右
                                int[] newItem = new int[2];
                                newItem[0] = item[0];
                                newItem[1] = item[1] + 1;
                                queue.offer(newItem);
                                visited[item[0]][item[1] + 1] = 1;
                            }
                            if (item[1] - 1 >= 0 && grid[item[0]][item[1] - 1] == '1' &&
                                visited[item[0]][item[1] - 1] == 0) {
                                // 左
                                int[] newItem = new int[2];
                                newItem[0] = item[0];
                                newItem[1] = item[1] - 1;
                                queue.offer(newItem);
                                visited[item[0]][item[1] - 1] = 1;
                            }
                            if (item[0] + 1 < height && grid[item[0] + 1][item[1]] == '1' &&
                                visited[item[0] + 1][item[1]] == 0) {
                                // 下
                                int[] newItem = new int[2];
                                newItem[0] = item[0] + 1;
                                newItem[1] = item[1];
                                queue.offer(newItem);
                                visited[item[0] + 1][item[1]] = 1;
                            }
                            if (item[0] - 1 >= 0 && grid[item[0] - 1][item[1]] == '1' &&
                                visited[item[0] - 1][item[1]] == 0) {
                                // 上
                                int[] newItem = new int[2];
                                newItem[0] = item[0] - 1;
                                newItem[1] = item[1];
                                queue.offer(newItem);
                                visited[item[0] - 1][item[1]] = 1;
                            }

                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        // char[][] grid = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        printGrid(grid);
        System.out.println(new NumIslands200().numIslands(grid));
    }

    private static void printGrid(char[][] grid) {
        for (char[] chars : grid) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
