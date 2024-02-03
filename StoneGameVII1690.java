/**
 * 1690. 石子游戏 VII
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2024/02/03
 */
public class StoneGameVII1690 {

    public int stoneGameVII(int[] stones) {
        // 前缀和 + 记忆化搜索
        int n = stones.length;
        int[] sum = new int[n + 1];
        int[][] mem = new int[n][n];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        return dfs(0, n - 1, sum, mem);
    }

    public int dfs(int i, int j, int[] sum, int[][] mem) {
        if (i >= j) {
            return 0;
        }
        if (mem[i][j] != 0) {
            return mem[i][j];
        }
        int res = Math.max(sum[j + 1] - sum[i + 1] - dfs(i + 1, j, sum, mem),
                sum[j] - sum[i] - dfs(i, j - 1, sum, mem));
        mem[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] stones = { 5, 3, 1, 4, 2 };
        // 6
        System.out.println(new StoneGameVII1690().stoneGameVII(stones));
    }
}
