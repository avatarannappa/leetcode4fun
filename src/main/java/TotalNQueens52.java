/**
 * 52. N皇后 II
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/29
 */
public class TotalNQueens52 {
    int n;
    int count = 0;

    public int totalNQueens(int n) {
        this.n = n;
        char[][] grid = new char[n][n];
        backTracking(grid, 0, 0);
        return count;
    }

    public boolean backTracking(char[][] grid, int x, int y) {
        if (y == n) {
            count++;
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (!check(grid, i, y)) {
                continue;
            }
            grid[y][i] = 'Q';
            if (backTracking(grid, i, y + 1)) {
                grid[y][i] = 0;
                continue;
            }
            grid[y][i] = 0;
        }
        return false;
    }

    public boolean check(char[][] grid, int x, int y) {
        for (int i = 0; i < n; i++) {
            // line
            if (grid[y][i] == 'Q') {
                return false;
            }
            // column
            if (grid[i][x] == 'Q') {
                return false;
            }
            // left
            if (y + i < n && x - i >= 0) {
                if (grid[y + i][x - i] == 'Q') {
                    return false;
                }
            }
            if (y - i >= 0 && x + i < n) {
                if (grid[y - i][x + i] == 'Q') {
                    return false;
                }
            }
            // right
            if (y + i < n && x + i < n) {
                if (grid[y + i][x + i] == 'Q') {
                    return false;
                }
            }
            if (y - i >= 0 && x - i >= 0) {
                if (grid[y - i][x - i] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new TotalNQueens52().totalNQueens(n));
    }

}
