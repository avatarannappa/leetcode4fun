import java.util.Arrays;

/**
 * 840. 矩阵中的幻方.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2025/12/30
 */
public class NumMagicSquaresInside840 {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row < 3 || col < 3) {
            return 0;
        }

        int num = 0;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                if (check(i, j, grid)) {
                    num++;
                }
            }
        }

        return num;
    }

    public boolean check(int i, int j, int[][] grid) {
        int sum = 0;
        boolean[] exist = new boolean[9];
        sum = checkTree(grid[i][j], grid[i+1][j+1], grid[i+2][j+2], exist);
        if (sum == -1) {
            return false;
        }
        Arrays.fill(exist, false);
        for (int m = 0; m < 3; m++) {
            int rowSum = checkTree(grid[i+m][j], grid[i+m][j+1], grid[i+m][j+2], exist);
            if (rowSum == -1 || sum != rowSum) {
                return false;
            }
        }
        Arrays.fill(exist, false);
        for (int n = 0; n < 3; n++) {
           int columnSum = checkTree(grid[i][j+n], grid[i+1][j+n], grid[i+2][j+n], exist);
           if (columnSum == -1 || sum != columnSum) {
               return false;
           }
        }
        Arrays.fill(exist, false);
        int sum9 = checkTree(grid[i][j+2], grid[i+1][j+1], grid[i+2][j], exist);
        if (sum9 == -1 || sum != sum9) {
            return false;
        }
        return true;
    }

    public int checkTree(int a, int b, int c, boolean[] exist) {
        if (a < 1 || a > 9 || exist[a - 1]) {
            return -1;
        }
        exist[a - 1] = true;
        if (b < 1 || b > 9 || exist[b - 1]) {
            return -1;
        }
        exist[b - 1] = true;
        if (c < 1 || c > 9 || exist[c - 1]) {
            return -1;
        }
        exist[c - 1] = true;
        return a + b + c;
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};
        System.out.println(new NumMagicSquaresInside840().numMagicSquaresInside(grid));
    }
}
