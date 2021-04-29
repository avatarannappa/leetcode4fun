import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/29
 */
public class MaxValueOffer47 {

    public int maxValue(int[][] grid) {
        // 动态规划
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    int[][] grid;
    Map<String, Integer> map = new HashMap<>();

    public int maxValueOld(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        this.grid = grid;
        return recursion(grid.length - 1, grid[0].length - 1);
    }

    public int recursion(int i, int j) {
        // 记忆化递归
        if (i < 0 || j < 0) {
            return 0;
        }
        String key = i + "-" + j;
        int ex = map.getOrDefault(key, -1);
        if (ex != -1) {
            return ex;
        }
        int res = Math.max(recursion(i - 1, j), recursion(i, j - 1)) + grid[i][j];
        map.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new MaxValueOffer47().maxValue(grid));
    }

}
