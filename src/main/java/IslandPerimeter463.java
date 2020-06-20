/**
 * 463. 岛屿的周长.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/20
 */
public class IslandPerimeter463 {

    int[][] grid;
    int[][] mask = {{-1, 0, 1, 0}, {0, 1, 0, -1}}; // 上下左右

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        this.grid = grid;
        int len = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    len += count(i, j);
                }
            }
        }
        return len;
    }

    public int count(int i, int j) {
        int sum = 0;
        for (int m = 0; m < 4; m++) {
            int ii = i + mask[0][m];
            int jj = j + mask[1][m];
            if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length) {
                if (grid[ii][jj] == 0) {
                    sum++;
                }
            } else {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(new IslandPerimeter463().islandPerimeter(grid));
    }
}
