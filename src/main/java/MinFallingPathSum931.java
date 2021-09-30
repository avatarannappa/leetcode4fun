/**
 * 931. 下降路径最小和. medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/30
 */
public class MinFallingPathSum931 {
    public int minFallingPathSum(int[][] matrix) {
        // DP
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][dp[0].length - 1] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int ii = i + 1;
                int jj = j + 1;
                dp[ii][jj] = Math.min(dp[ii - 1][jj - 1], Math.min(dp[ii - 1][jj], dp[ii - 1][jj + 1])) + matrix[i][j];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < dp[0].length; i++) {
            result = Math.min(dp[dp.length - 1][i], result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(new MinFallingPathSum931().minFallingPathSum(matrix));
    }
}
