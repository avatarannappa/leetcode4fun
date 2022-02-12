/**
 * 1020. 飞地的数量.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/2/12
 */
public class NumEnclaves1020 {

    public static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;
    private boolean[][] visited;

    public int numEnclaves(int[][] grid) {
        // 多源dfs
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        int enclaves = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    public void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1]);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0},
                        {1, 0, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0}};
        System.out.println(new NumEnclaves1020().numEnclaves(grid));
    }
}
