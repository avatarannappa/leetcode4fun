/**
 * 2022. 将一维数组转变成二维数组.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/1/1
 */
public class Construct2DArray2022 {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[i * n + j];
            }
        }
        return ans;
    }

}
