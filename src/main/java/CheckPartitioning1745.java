/**
 * 1745. 分割回文串 IV.
 * hard
 *
 * @author avatarannappa
 * @version 2025/3/4
 */
public class CheckPartitioning1745 {

    public boolean checkPartitioning(String s) {
        return palindromePartition(s, 3) == 0;
    }

    // 1278. 分割回文串 III
    private int palindromePartition(String S, int k) {
        // 递归
        char[] s = S.toCharArray();
        int n = s.length;
        int[][] minChange = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                minChange[i][j] = minChange[i + 1][j - 1] + (s[i] != s[j] ? 1 : 0);
            }
        }

        int[] f = minChange[0];
        for (int i = 1; i < k; i++) {
            for (int r = n - k + i; r >= i; r--) {
                f[r] = Integer.MAX_VALUE;
                for (int l = i; l <= r; l++) {
                    f[r] = Math.min(f[r], f[l - 1] + minChange[l][r]);
                }
            }
        }
        return f[n - 1];
    }

}
