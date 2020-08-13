/**
 * 695. 岛屿的最大面积.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/14
 */
public class MaxAreaOfIsland695 {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int result = 0;
    int temp = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    temp++;
                    mark(i, j, grid);
                }
                temp = 0;
            }
        }

        return result;
    }

    public void mark(int i, int j, int[][] grid) {
        grid[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            int ii = i + dx[k];
            int jj = j + dy[k];
            if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] == 1) {
                temp++;
                mark(ii, jj, grid);
            }
        }
        result = Math.max(result, temp);
    }

    public static void main(String[] args) {
                int[][] grid = {
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
//        int[][] grid = {
//                {0, 1, 1},
//                {1, 1, 0}};
        System.out.println(new MaxAreaOfIsland695().maxAreaOfIsland(grid));
    }
}
