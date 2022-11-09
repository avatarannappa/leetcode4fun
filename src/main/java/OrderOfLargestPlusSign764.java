import java.util.Arrays;

/**
 * 764. 最大加号标志
 * medium
 *
 * @author avatarannappa
 * @date 2022/11/9
 */
public class OrderOfLargestPlusSign764 {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        // O(n**2) 预处理
        // TODO DP 
        int[][] g = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(g[i], 1);
        }
        for (int[] info : mines) {
            g[info[0] + 1][info[1] + 1] = 0;
        }
        int[][] a = new int[n + 2][n + 2];
        int[][] b = new int[n + 2][n + 2];
        int[][] c = new int[n + 2][n + 2];
        int[][] d = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (g[i][j] == 1) {
                    a[i][j] = a[i - 1][j] + 1;
                    b[i][j] = b[i][j - 1] + 1;
                }
                if (g[n + 1 - i][n + 1 - j] == 1) {
                    c[n + 1 - i][n + 1 - j] = c[n + 2 - i][n + 1 - j] + 1;
                    d[n + 1 - i][n + 1 - j] = d[n + 1 - i][n + 2 - j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans = Math.max(ans, Math.min(Math.min(a[i][j], b[i][j]), Math.min(c[i][j], d[i][j])));
            }
        }
        return ans;
    }

    public int orderOfLargestPlusSignOld(int n, int[][] mines) {
        // O(n**3)
        int ans = 0;
        int[][] grid = new int[n][n];
        for (int i = 0; i < mines.length; i++) {
            grid[mines[i][0]][mines[i][1]] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, find(grid, i, j, n));
            }
        }
        return ans;
    }

    int find(int grid[][], int x, int y, int n) {
        if (grid[x][y] == 1) {
            return 0;
        }
        int k = 1;
        while (true) {
            if (x - k < 0 || grid[x - k][y] == 1 || x + k == n || grid[x + k][y] == 1 || y - k < 0
                || grid[x][y - k] == 1 || y + k == n || grid[x][y + k] == 1) {
                break;
            }
            k++;
        }
        return k;
    }

    public static void main(String[] args) {
        // 输入: n = 5, mines = [[4, 2]]
        // 输出: 2
        int n = 5;
        int[][] mines = {{4, 2}};
        System.out.println(new OrderOfLargestPlusSign764().orderOfLargestPlusSign(n, mines));
    }
}
