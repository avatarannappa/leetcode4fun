import java.util.Arrays;

/**
 * 867. 转置矩阵
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/1/29
 */
public class Transpose867 {

    public int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] res = new int[col][row];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                res[j][i] = A[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}};
        int[][] res = new Transpose867().transpose(A);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}
