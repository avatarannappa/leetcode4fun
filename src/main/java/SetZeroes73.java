/**
 * 73. 矩阵置零
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/12
 */
public class SetZeroes73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        boolean mZero = false;
        boolean nZero = false;
        int m = matrix[0].length;
        int n = matrix.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 列
                if (matrix[j][i] == 0) {
                    matrix[j][0] = 0;
                    matrix[0][i] = 0;
                    if (j == 0) {
                        mZero = true;
                    }
                    if (i == 0) {
                        nZero = true;
                    }
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[j][0] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (mZero) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }

        if (nZero) {
            for (int j = 0; j < n; j++) {
                matrix[j][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 9, 0}, {2, 4, 8, 10}, {13, 3, 6, 7}};

        new SetZeroes73().setZeroes(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(",");
            }
            System.out.println("");
        }
    }
}
