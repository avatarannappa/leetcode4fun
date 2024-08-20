/**
 * 3154. 到大第 K 级台阶的方案数.
 * hard
 *
 * @author avatarannappa
 * @date 2024/8/20
 */
public class WaysToReachStair3154 {

    private static int n = 31;
    private static int[][] c = new int[n][n];

    static {
        // 递推 
        //  组合数计算 https://www.acwing.com/blog/content/22112/
        for (int i = 1; i < n; i++) {
            c[i][0] = 1;
            c[i][i] = 1;
            for (int j = 1; j < i; j++) {
                c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
            }
        }
    }

    public int waysToReachStair(int k) {
        //  组合数学 + 等比数列求和
        // TODO 记忆化搜索
        int res = 0;
        // 枚举
        for (int i = 0; i < 30; i++) {
            int m = (1 << i) - k;
            if (0 <= m && m <= i + 1) {
                res += c[i + 1][m];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int k = 1;
        // 4
        System.out.println(new WaysToReachStair3154().waysToReachStair(k));
    }


}
