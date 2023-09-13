/**
 * 2596. 检查骑士巡视方案
 * medium
 *
 * @author avatarannappa
 * @date 2023/9/13
 */
public class CheckValidGrid2596 {

    int[][] steps = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int now = grid[i][j];
                if (now == 0) {
                    continue;
                }
                boolean sign = false;
                for (int[] step : steps) {
                    int ii = i + step[0];
                    int jj = j + step[1];
                    if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid.length) {
                        if (grid[ii][jj] == now - 1) {
                            sign = true;
                            break;
                        }
                    }
                }
                if (!sign) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 11, 16, 5, 20},
            {17, 4, 19, 10, 15},
            {12, 1, 8, 21, 6},
            {3, 18, 23, 14, 9},
            {24, 13, 2, 7, 22}};
        // true
        System.out.println(new CheckValidGrid2596().checkValidGrid(grid));
    }
}
