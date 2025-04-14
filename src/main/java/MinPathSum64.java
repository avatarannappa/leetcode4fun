import java.util.Arrays;

/**
 * 64. 最小路径和.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/5
 */
public class MinPathSum64 {

    public int minPathSum(int[][] grid) {
        // 动态规划
        if (grid == null) {
            return 0;
        }
        int m = grid[0].length - 1;
        int n = grid.length - 1;

        for (int j = 0; j <= n; j++) {
            for (int i = 0; i <= m; i++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (j == 0) {
                    grid[j][i] += grid[j][i - 1];
                } else if (i == 0) {
                    grid[j][i] += grid[j - 1][i];
                } else {
                    grid[j][i] += Math.min(grid[j][i - 1], grid[j - 1][i]);
                }
            }
            // System.out.println(Arrays.toString(grid[j]));
        }
        return grid[n][m];
    }

    int[][] grid;
    int m;
    int n;
    int min = Integer.MAX_VALUE;
    int[][] memo;

    public int minPathSumMemo(int[][] grid) {
        // 记忆化搜索
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfsMemo(m - 1, n - 1);
    }

    public int dfsMemo(int i, int j) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        memo[i][j] = Math.min(dfsMemo(i, j - 1), dfsMemo(i - 1, j)) + grid[i][j];
        return memo[i][j];
    }

    public int minPathSumDfs(int[][] grid) {
        // 超时
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        dfs(0, 0, 0);
        return min;
    }

    public void dfs(int i, int j, int sum) {
        if (i == m - 1 && j == n - 1) {
            min = Math.min(min, sum + grid[i][j]);
            return;
        }
        sum += grid[i][j];
        if (i + 1 < m) {
            dfs(i + 1, j, sum);
        }
        if (j + 1 < n) {
            dfs(i, j + 1, sum);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new MinPathSum64().minPathSum(grid));
    }
}
