/**
 * 552. 学生出勤记录 II.
 * hard
 *
 * @author avatarannappa
 * @date 2024/8/19
 */
public class CheckRecord552 {

    private static final int MOD = 10_0000_0007;
    private static final int MX = 10_0001;
    private static final int[][][] memo = new int[MX][3][2];
    private static final int[][][] DP = new int[MX][3][2];

    static {
        DP[0] = new int[][]{{1, 1}, {1, 1}, {1, 1}};
        for (int i = 1; i < MX; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    long sum = DP[i - 1][0][k];
                    if (j < 2) {
                        sum += DP[i - 1][j + 1][k];
                    }
                    if (k < 1) {
                        sum += DP[i - 1][0][k + 1];
                    }
                    DP[i][j][k] = (int) (sum % MOD);
                }
            }
        }
    }

    public int checkRecord(int n) {
        // DP
        return DP[n][0][0];
    }

    public int checkRecordDFS(int n) {
        // java.lang.StackOverflowError 栈溢出了，可以ac 
        // dfs + 记忆
        return dfs(n, 0, 0);
    }

    /**
     * 深度优先.
     *
     * @param i index
     * @param j 后面挨着的连续late 数量
     * @param k absent 数量
     * @return 可能方案数量
     */
    public int dfs(int i, int j, int k) {
        long res = 0;
        if (i == 0) {
            return 1;
        }
        if (memo[i][j][k] != 0) {
            return memo[i][j][k];
        }

        // i位present
        res += dfs(i - 1, 0, k);
        // i位late
        if (j < 2) {
            res += dfs(i - 1, j + 1, k);
        }
        // i位absent
        if (k < 1) {
            res += dfs(i - 1, 0, k + 1);
        }
        return memo[i][j][k] = (int) (res % MOD);
    }

    public static void main(String[] args) {
        // 1 <= n <= 10^5
        int n = 10101;
        // 8
        System.out.println(new CheckRecord552().checkRecord(n));
    }

}
