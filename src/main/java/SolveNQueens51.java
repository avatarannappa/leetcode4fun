import java.util.ArrayList;
import java.util.List;

/**
 * 51. N皇后.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/28
 */
public class SolveNQueens51 {

    int n;
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        char[][] grid = new char[n][n];
        backTracking(grid, 0, 0);
        return result;
    }

    public boolean backTracking(char[][] grid, int x, int y) {
        if (y == n) {
            addList(grid);
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

    public void addList(char[][] grid) {
        List<String> tempList = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            String str = "";
            for (int i = 0; i < n; i++) {
                if (grid[j][i] == 'Q') {
                    str += 'Q';
                } else {
                    str += '.';
                }
            }
            tempList.add(str);
        }
        result.add(tempList);
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
        System.out.println(new SolveNQueens51().solveNQueens(n));
    }
}
