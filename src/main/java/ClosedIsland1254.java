/**
 * 1254. 统计封闭岛屿的数目.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/15
 */
public class ClosedIsland1254 {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) && grid[i][j] == 0) {
                    mark(i, j, grid);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    result++;
                    mark(i, j, grid);
                }
            }
        }

        return result;
    }

    public void mark(int i, int j, int[][] grid) {
        grid[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            int ii = i + dx[k];
            int jj = j + dy[k];
            if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] == 0) {
                mark(ii, jj, grid);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid =
                {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0}};
        System.out.println(new ClosedIsland1254().closedIsland(grid));
    }

}
