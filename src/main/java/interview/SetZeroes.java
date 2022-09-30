package interview;

/**
 * 面试题 01.08. 零矩阵
 * medium
 *
 * @author avatarannappa
 * @date 2022/9/30
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] mask = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int x = 0; x < m; x++) {
                        mask[x][j] = true;
                    }
                    for (int y = 0; y < n; y++) {
                        mask[i][y] = true;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mask[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

}
