/**
 * 62. 不同路径
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/10
 */
public class UniquePaths62 {

    public int uniquePaths(int m, int n) {
        if (m < 2 || n < 2) {
            return 1;
        }
        // C m+n n
        return combination(m + n - 2, Math.min(m - 1, n - 1));
    }

    int combination(int n, int m) {
        long ans = 1;
        for (int i = n; i >= (n - m + 1); --i) {
            ans *= i;
        }
        long b = 1;
        while (m > 0) {
            b *= m;
            m--;
        }
        return (int) (ans / b);
    }

    public int uniquePathsOld(int m, int n) {
        // 51 9 超时
        if (m < 2 || n < 2) {
            return 1;
        }
        return step(1, 1, m, n);
    }

    public int step(int x, int y, int m, int n) {
        int count = 0;
        if (x == m && y == n) {
            return 0;
        } else if (x < m && y < n) {
            count = step(x, y + 1, m, n) + step(x + 1, y, m, n);
        } else if (x == m || y == n) {
            count = 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths62().uniquePaths(10, 10));
    }
}
