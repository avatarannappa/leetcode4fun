import java.util.Arrays;

/**
 * 1314. 矩阵区域和,Matrix Block Sum. medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/10/08
 */
public class MatrixBlockSum1314 {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        if (mat == null || k == 0) {
            return mat;
        }
        int h = mat.length;
        int w = mat[0].length;
        int[][] preSum = new int[h + 2 * k + 2][w + 2 * k + 2];
        int[][] result = new int[h][w];
        int ii = 0;
        int jj = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                ii = i + k + 1;
                jj = j + k + 1;
                preSum[ii][jj] = preSum[ii - 1][jj] + preSum[ii][jj - 1] - preSum[ii - 1][jj - 1] + mat[i][j];

            }
        }
        for (int i = 0; i < preSum.length; i++) {
            System.out.println(Arrays.toString(preSum[i]));
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                ii = i + k + 1;
                jj = j + k + 1;
                int bottomI = Math.min(k + h, ii + k);
                int bottomJ = Math.min(k + w, jj + k);
                int topI = ii - k - 1;
                int topJ = jj - k - 1;
                result[i][j] = preSum[bottomI][bottomJ] + preSum[topI][topJ] - preSum[bottomI][topJ]
                        - preSum[topI][bottomJ];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int k = 1;
        int[][] result = new MatrixBlockSum1314().matrixBlockSum(mat, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

}
