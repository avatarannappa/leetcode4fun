/**
 * 221. 最大正方形
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/6
 */
public class MaximalSquare221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = matrix[0][0] - '0';
        int width = matrix[0].length;
        int height = matrix.length;
        int[][] dp = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0) {
                    dp[0][j] = matrix[0][j] - '0';
                } else if (j == 0) {
                    dp[i][0] = matrix[i][0] - '0';
                } else {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'0', '1'}};
        System.out.println(new MaximalSquare221().maximalSquare(matrix));
    }
}
