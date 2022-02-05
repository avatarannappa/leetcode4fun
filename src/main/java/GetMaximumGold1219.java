/**
 * 1219. 黄金矿工
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/2/5
 */
public class GetMaximumGold1219 {
    int m;
    int n;
    int ans = 0;
    int[][] grid;
    int[][] mask = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    backTracking(new int[m][n], i, j, 0);
                }
            }
        }
        return ans;
    }

    public void backTracking(int[][] visited, int x, int y, int sum) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        if (visited[x][y] == 1) {
            return;
        }
        if (grid[x][y] == 0) {
            return;
        }
        sum = sum + grid[x][y];
        visited[x][y] = 1;
        ans = Math.max(ans, sum);
        for (int i = 0; i < 4; i++) {
            int nx = x + mask[i][0];
            int ny = y + mask[i][1];
            backTracking(visited, nx, ny, sum);
        }
        visited[x][y] = 0;
    }

}
