/**
 * 688. 骑士在棋盘上的概率.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/2/17
 */
public class Knightprobability688 {

    public static final int[][] mask = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    public double knightProbability(int n, int k, int row, int column) {
        // DP 棋子在i x j位置，第k步
        double[][][] dp = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int step = 1; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] m : mask) {
                        int nx = i + m[0];
                        int ny = j + m[1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }
                        dp[i][j][step] += dp[nx][ny][step - 1] / 8;
                    }
                }
            }
        }

        return dp[row][column][k];
    }

    public double knightProbabilityMine(int n, int k, int row, int column) {
        // DP 棋子在i x j位置，第k步
        double[][][] dp = new double[n][n][k + 1];
        dp[row][column][0] = 1;
        for (int step = 1; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] m : mask) {
                        int nx = i + m[0];
                        int ny = j + m[1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }
                        dp[nx][ny][step] += dp[i][j][step - 1] / 8;
                    }
                }
            }
        }

        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += dp[i][j][k];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        int row = 0;
        int column = 0;
        System.out.println(new Knightprobability688().knightProbabilityMine(n, k, row, column));
    }

}
