import java.util.Arrays;

/**
 * 3033. 修改矩阵
 * easy
 *
 * @author avatarannappa
 * @date 2024/7/5
 */
public class ModifiedMatrix3033 {

    public int[][] modifiedMatrix(int[][] matrix) {
        // 简单模拟
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        int[] max = new int[n];
        Arrays.fill(max, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max[i] = Math.max(max[i], matrix[j][i]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    res[i][j] = max[j];
                } else {
                    res[i][j] = matrix[i][j];
                }
            }
        }
        return res;
    }
}
