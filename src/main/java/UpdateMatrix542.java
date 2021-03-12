import java.util.Arrays;

/**
 * 542. 01 矩阵
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/11
 */
public class UpdateMatrix542 {

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = m * n;
        int num = 0;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    num++;
                } else {
                    result[i][j] = -1;
                }
            }
        }
        int level = 0;
        while (num < count) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (result[i][j] == -1) {
                        int min = Integer.MAX_VALUE;
                        if (i > 0 && result[i - 1][j] != -1) {
                            min = Math.min(min, result[i - 1][j]);
                        }
                        if (i < m - 1 && result[i + 1][j] != -1) {
                            min = Math.min(min, result[i + 1][j]);
                        }
                        if (j > 0 && result[i][j - 1] != -1) {
                            min = Math.min(min, result[i][j - 1]);
                        }
                        if (j < n - 1 && result[i][j + 1] != -1) {
                            min = Math.min(min, result[i][j + 1]);
                        }
                        if (min == level) {
                            result[i][j] = min + 1;
                            num++;
                        }
                    }
                }
            }
            level++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,0,0,1,0,0,1,1,0},
                {1,0,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,1,1,1,1,0},
                {0,1,1,1,0,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,0,1,1,1},
                {0,1,1,1,1,1,1,0,0,1},
                {1,1,1,1,1,0,0,1,1,1},
                {0,1,0,1,1,0,1,1,1,1},
                {1,1,1,0,1,0,1,1,1,1}};
        int[][] result = new UpdateMatrix542().updateMatrix(matrix);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
