import java.util.Arrays;

/**
 * 1140. 石子游戏 II
 * medium
 *
 * @author avatarannappa
 * @date 2023/2/22
 */
public class StoneGameII1140 {

    private int[] postSum;
    private int[][] mem;

    public int stoneGameII(int[] piles) {
        // 记忆化搜索
        postSum = piles;
        int n = piles.length;
        for (int i = n - 2; i >= 0; i--) {
            postSum[i] += postSum[i + 1];
        }
        mem = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mem[i], -1);
        }
        return dfs(0, 1);
    }

    private int dfs(int i, int m) {
        if (i + m * 2 >= postSum.length) {
            // 结束条件，能拿完，不给对手留
            return postSum[i];
        }
        if (mem[i][m] != -1) {
            return mem[i][m];
        }
        int ans = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; x++) {
            // 对手能拿的最少
            ans = Math.min(ans, dfs(i + x, Math.max(m, x)));
        }
        mem[i][m] = postSum[i] - ans;
        return mem[i][m];
    }

    public static void main(String[] args) {
        int[] piles = {2, 7, 9, 4, 4};
        // 10
        System.out.println(new StoneGameII1140().stoneGameII(piles));
    }
}
