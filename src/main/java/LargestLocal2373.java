/**
 * 2373. 矩阵中的局部最大值
 * easy
 *
 * @author avatarannappa
 * @date 2023/3/1
 */
public class LargestLocal2373 {

    int[][] mask = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int a = grid[i][j];
                for (int[] m : mask) {
                    a = Math.max(a, grid[i + m[0]][j + m[1]]);
                }
                ans[i - 1][j - 1] = a;
            }
        }

        return ans;
    }

}
