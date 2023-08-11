/**
 * 1572. 矩阵对角线元素的和
 * easy
 *
 * @author avatarannappa
 * @date 2023/8/11
 */
public class DiagonalSum1572 {

    public int diagonalSum(int[][] mat) {
        // 模拟
        int ans = 0;

        int n = mat.length;
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            if (i == mid && n % 2 == 1) {
                ans += mat[i][i];
            } else {
                ans += mat[i][i];
                ans += mat[i][n - 1 - i];
            }
        }

        return ans;
    }
}
