/**
 * 1582. 二进制矩阵中的特殊位置
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/9/4
 */
public class NumSpecial1582 {

    public int numSpecial(int[][] mat) {
        int ans = 0;
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int jj = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    count++;
                    jj = j;
                }
            }
            if (count != 1) {
                continue;
            }
            boolean sign = true;
            for (int k = 0; k < n; k++) {
                if (k != i && mat[k][jj] == 1) {
                    sign = false;
                    break;
                }
            }
            if (sign) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(new NumSpecial1582().numSpecial(mat));
    }
}
