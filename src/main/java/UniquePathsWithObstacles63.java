import java.util.HashMap;
import java.util.Map;

/**
 * 63. 不同路径 II
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/31
 */
public class UniquePathsWithObstacles63 {

    int[][] obstacleGrid;
    int m;
    int n;
    Map<String, Integer> mem = new HashMap<>();

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 记忆化搜索
        this.obstacleGrid = obstacleGrid;
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        return recursion(0, 0);
    }

    public int recursion(int i, int j) {
        String key = i + "#" + j;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        int left = 0;
        if (j + 1 < n && obstacleGrid[i][j + 1] == 0) {
            left = recursion(i, j + 1);
        }
        int down = 0;
        if (i + 1 < m && obstacleGrid[i + 1][j] == 0) {
            down = recursion(i + 1, j);
        }
        mem.put(key, left + down);
        return left + down;
    }

    public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        // DP 动态规划
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        long[][] dp = new long[m][n];
        int first = obstacleGrid[0][0];
        if (first == 1) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return (int) dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new UniquePathsWithObstacles63().uniquePathsWithObstacles(obstacleGrid));
    }
}
