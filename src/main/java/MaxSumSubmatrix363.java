/**
 * 363. 矩形区域不超过K的最大数值和.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/4
 */
public class MaxSumSubmatrix363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        // 前缀和 280ms 超过64%
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
                if (sum[i + 1][j + 1] <= k) {
                    max = Math.max(max, sum[i + 1][j + 1]);
                    if (max == k) {
                        return max;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = i + 1; x < m + 1; x++) {
                    for (int y = j + 1; y < n + 1; y++) {
                        int area = sum[x][y] - sum[i][y] - sum[x][j] + sum[i][j];
                        if (area <= k) {
                            max = Math.max(max, area);
                            if (max == k) {
                                return max;
                            }
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 0, 1 }, { 0, -2, 3 } };
        int k = 2;
        System.out.println(new MaxSumSubmatrix363().maxSumSubmatrix(matrix, k));
    }
}
