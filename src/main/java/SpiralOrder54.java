import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/8
 */
public class SpiralOrder54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // m x n
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        if (matrix.length == 1) {
            result.add(matrix[0][0]);
            return result;
        }
        int m = matrix[0].length;
        int n = matrix.length;
        int mHarf = m / 2;
        int nHarf = n / 2;

        int mOffset = m - 1;
        int nOffset = n - 1;

        int i = 0, j = 0;
        for (i = 0, j = 0; i < mHarf && j < nHarf; i++, j++) {
            for (int t = 0; t < mOffset; t++) {
                result.add(matrix[i][j + t]);
            }
            for (int t = 0; t < nOffset; t++) {
                result.add(matrix[i + t][j + mOffset]);
            }
            for (int t = 0; t < mOffset; t++) {
                result.add(matrix[i + nOffset][j + mOffset - t]);
            }
            for (int t = 0; t < nOffset; t++) {
                result.add(matrix[i + nOffset - t][j]);
            }
            mOffset -= 2;
            nOffset -= 2;
        }

        if (mOffset == 0) {
            for (int t = 0; t <= nOffset; t++) {
                result.add(matrix[i + t][j]);
            }
        } else if (nOffset == 0) {
            for (int t = 0; t <= mOffset; t++) {
                result.add(matrix[i][j + t]);
            }
        }

        return result;
    }

    public List<Integer> spiralOrderOld(int[][] matrix) {
        // n x n 正方形
        List<Integer> result = new ArrayList<>();
        int length = matrix.length;
        int harf = length / 2;

        int offset = length - 1;

        for (int i = 0, j = 0; i < harf; i++, j++) {
            for (int t = 0; t < offset; t++) {
                result.add(matrix[i][j + t]);
            }
            for (int t = 0; t < offset; t++) {
                result.add(matrix[i + t][j + offset]);
            }
            for (int t = 0; t < offset; t++) {
                result.add(matrix[i + offset][j + offset - t]);
            }
            for (int t = 0; t < offset; t++) {
                result.add(matrix[i + offset - t][j]);
            }
            offset -= 2;
        }

        if (length % 2 == 1) {
            result.add(matrix[harf][harf]);
        }

        return result;
    }

    public static void main(String[] args) {
        // int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new SpiralOrder54().spiralOrder(matrix));
    }
}
