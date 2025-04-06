import java.util.Arrays;

/**
 * 1278. 分割回文串 III.
 * hard
 *
 * @author avatarannappa
 * @version 2025/3/4
 */
public class PalindromePartition1278 {

    public int palindromePartition(String s, int k) {
        // 记忆化搜索
        // 递归 CheckPartitioning1745
        int n = s.length();
        int[][] memoChange = new int[n][n];
        for (int[] row : memoChange) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        int[][] memoDfs = new int[k][n];
        for (int[] row : memoDfs) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(k - 1, n - 1, s.toCharArray(), memoDfs, memoChange);
    }

    private int dfs(int i, int r, char[] s, int[][] memoDfs, int[][] memoChange) {
        if ( i == 0) {
            // 不切，1个串
            return change(0, r, s, memoChange);
        }
        if (memoDfs[i][r] != -1) {
            return memoDfs[i][r];
        }
        int res = Integer.MAX_VALUE;
        for(int j = i; j <= r; j++) {
            res = Math.min(res, dfs(i - 1, j - 1, s, memoDfs, memoChange) + change(j, r, s, memoChange));
        }
        return memoDfs[i][r] = res;
    }
    
    public int change(int l, int r, char[] s, int[][] memoChange) {
        // 一个字符串改成回文串需要的改动次数，双指针
        if (l >= r) {
            return 0;
        }
        if (memoChange[l][r] != -1) {
            return memoChange[l][r];
        }
        int res = change(l + 1, r - 1, s, memoChange);
        if (s[l] != s[r]) {
            res++;
        }
        return memoChange[l][r] = res;
    }

    public static void main(String[] args) {
        String s = "aabbc";
        int k = 3;
        System.out.println(new PalindromePartition1278().palindromePartition(s, k));
    }

}
