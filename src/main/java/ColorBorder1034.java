import java.util.Arrays;

/**
 * 1034, 边界着色.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/20
 */
public class ColorBorder1034 {

    int originColor;
    int[][] grid;
    int[][] visited;
    int color;
    int[][] mask = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        originColor = grid[row][col];
        this.grid = grid;
        this.visited = new int[grid.length][grid[0].length];
        this.color = color;
        recursion(row, col);
        return this.grid;
    }

    private boolean recursion(int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return false;
        }
        if (grid[row][col] == originColor && visited[row][col] == 0) {
            grid[row][col] = color;
            visited[row][col] = 1;
            boolean sign = true;
            for (int[] m : mask) {
                sign &= recursion(row + m[0], col + m[1]);
            }
            if (sign) {
                grid[row][col] = originColor;
            }
            return true;
        } else if (visited[row][col] == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 1 }, { 1, 1, 1 } , {1,1,1}};
        int row = 1;
        int col = 1;
        int color = 2;
        // [[1,3,3],[2,3,3]]
        int[][] ans = new ColorBorder1034().colorBorder(grid, row, col, color);
        for (int[] a : ans) {
            System.out.println(Arrays.toString(a));
        }
    }
}
