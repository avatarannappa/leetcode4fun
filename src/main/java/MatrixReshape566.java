import java.util.Arrays;

/**
 * 566. 重塑矩阵. easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/8/30
 */
public class MatrixReshape566 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        int x = 0;
        int y = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[x][y] = mat[i][j];
                y = (y + 1) % c;
                if (y == 0) {
                    x++;
                }
                if (x >= r) {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;
        int[][] res = new MatrixReshape566().matrixReshape(mat, r, c);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}
