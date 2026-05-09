import java.util.Arrays;

/**
 * 1914. Cyclically Rotating a Grids
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2026/5/9
 */
public class RotateGrid1914 {

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int minX = Math.min(i, m - 1 - i);
                int minY = Math.min(j, n - 1 - j);
                minX = Math.min(minX, minY);
                minY = minX;
                int maxX = m - 1 - minX;
                int maxY = n - 1 - minY;
                // mod 取模，避免重复旋转. 周长
                int mod = k % (2 * ((maxX - minX) + (maxY - minY)));
                int ii = i;
                int jj = j;
                while (mod > 0) {
                    if (ii == minX) {
                        if (jj == minY) {
                            ii++;
                        } else {
                            jj--;
                        }
                    } else if (ii == maxX) {
                        if (jj == maxY) {
                            ii--;
                        } else {
                            jj++;
                        }
                    } else if (jj == minY) {
                        ii++;
                    } else {
                        ii--;
                    }
                    mod--;
                }
                res[ii][jj] = grid[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
        //Output: [[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
        int[][] grid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int k = 2;
        int[][] res = new RotateGrid1914().rotateGrid(grid, k);
        System.out.println(Arrays.deepToString(res));
    }
}
