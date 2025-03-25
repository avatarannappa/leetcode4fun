import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 200. 岛屿数量.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/21
 */
public class NumIslands200 {

    public int numIslandsDFS(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    public int numIslandsBFS(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    int[][] mask = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            List<int[]> l = new ArrayList<>();
            while (!q.isEmpty()) {
                int[] p = q.poll();
                for (int[] arrow : mask) {
                    int x = p[0] + arrow[0];
                    int y = p[1] + arrow[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y] && grid[x][y] == '1') {
                        visited[x][y] = true;
                        l.add(new int[]{x, y});
                    }
                }
            }
            q.addAll(l);
        }
    }

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
