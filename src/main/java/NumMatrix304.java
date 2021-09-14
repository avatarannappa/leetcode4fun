/**
 * 304. 二维区域和检索 - 矩阵不可变 medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/15
 */
public class NumMatrix304 {

    int[][] matrix;
    int[][] mask;

    public NumMatrix304(int[][] matrix) {
        this.matrix = matrix;
        // 前缀和数组多定义一层，减少row column为0的判断
        mask = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < mask.length; i++) {
            for (int j = 1; j < mask[0].length; j++) {
                mask[i][j] = matrix[i - 1][j - 1] + mask[i][j - 1] + mask[i - 1][j] - mask[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return mask[row2 + 1][col2 + 1] - mask[row2 + 1][col1] - mask[row1][col2 + 1] + mask[row1][col1];
    }

    // -------------------新旧分割线-------------------
    public void NumMatrix304Old(int[][] matrix) {
        this.matrix = matrix;
        mask = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    mask[i][j] = matrix[i][j];
                } else if (i == 0) {
                    mask[i][j] = matrix[i][j] + mask[i][j - 1];
                } else if (j == 0) {
                    mask[i][j] = matrix[i][j] + mask[i - 1][j];
                } else {
                    mask[i][j] = matrix[i][j] + mask[i][j - 1] + mask[i - 1][j] - mask[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegionOld(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return mask[row2][col2];
        } else if (row1 == 0) {
            return mask[row2][col2] - mask[row2][col1 - 1];
        } else if (col1 == 0) {
            return mask[row2][col2] - mask[row1 - 1][col2];
        } else {
            return mask[row2][col2] - mask[row2][col1 - 1] - mask[row1 - 1][col2] + mask[row1 - 1][col1 - 1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}};
        // param 2,1,4,3
        // result 8
        System.out.println(new NumMatrix304(matrix).sumRegion(2, 1, 4, 3));
    }
}
