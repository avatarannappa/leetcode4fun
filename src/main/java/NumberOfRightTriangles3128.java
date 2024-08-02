/**
 * 3128. 直角三角形
 * medium
 *
 * @author avatarannappa
 * @date 2024/8/2
 */
public class NumberOfRightTriangles3128 {

    public long numberOfRightTriangles(int[][] grid) {
        // 数学(乘法原理)
        int m = grid.length;
        int n = grid[0].length;
        long ans = 0;

        long[] rowSum = new long[m];
        long[] colSum = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && rowSum[i] > 0 && colSum[j] > 0) {
                    ans += (rowSum[i] - 1) * (colSum[j] - 1);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0}, {0, 1, 1}, {0, 1, 0}};
        // 输出：2
        System.out.println(new NumberOfRightTriangles3128().numberOfRightTriangles(grid));
    }
}
