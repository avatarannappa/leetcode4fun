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

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new MinPathSum64().minPathSum(grid));
    }
}
