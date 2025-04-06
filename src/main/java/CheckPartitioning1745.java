import java.util.Arrays;

/**
 * 1745. 分割回文串 IV.
 * hard
 *
 * @author avatarannappa
 * @version 2025/3/4
 */
public class CheckPartitioning1745 {

    char[] s;

    public boolean checkPartitioning(String s) {
        return palindromePartitionNew(s, 3) == 0;
    }

    private int palindromePartitionNew(String S, int k) {
        // 递推
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

    // 1278. 分割回文串 III
    private int palindromePartition(String S, int k) {
        // 递归
        int n = S.length();
        this.s = S.toCharArray();

        int[][] mem = new int[n][n];
        for (int i = 0; i < n; i++) {
            // 缓存change结果
            Arrays.fill(mem[i], -1);
        }
        int[][] dMem = new int[n][k];
        for (int i = 0; i < n; i++) {
            // 缓存dfs结果
            Arrays.fill(dMem[i], -1);
        }
        return dfs(n - 1, k - 1, mem, dMem);
    }

    public int dfs(int r, int k, int[][] mem, int[][] dMemo) {
        // i是s右index，k是要分成k个串
        if (k == 0) {
            return change(0, r, mem);
        }
        if (dMemo[r][k] != -1) {
            return dMemo[r][k];
        }
        int res = Integer.MAX_VALUE;
        for (int rr = k; rr <= r; rr++) {
            res = Math.min(res, dfs(rr - 1, k - 1, mem, dMemo) + change(rr, r, mem));
        }
        return dMemo[r][k] = res;
    }

    public int change(int l, int r, int[][] mem) {
        if (l >= r) {
            return 0;
        }
        if (mem[l][r] != -1) {
            return mem[l][r];
        }
        int res = change(l + 1, r - 1, mem);
        if (s[l] != s[r]) {
            res++;
        }
        return mem[l][r] = res;
    }

    public static void main(String[] args) {
        String s = "abcbdd";
        System.out.println(new CheckPartitioning1745().checkPartitioning(s));
    }

}
