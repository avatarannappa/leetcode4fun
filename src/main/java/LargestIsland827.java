import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 827. 最大人工岛
 * hard
 *
 * @author avatarannappa
 * @date 2022/9/22
 */
public class LargestIsland827 {

    int[][] mask = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] grid;
    String[][] visited;
    int n;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.visited = new String[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<int[]> list = new ArrayList<>();
                String key = i + "#" + j;
                int count = dfs(i, j, key, list);
                for (int[] l : list) {
                    grid[l[0]][l[1]] = count;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, cal(i, j));
            }
        }

        return ans;
    }

    private int dfs(int i, int j, String key, List<int[]> list) {
        if (out(i, j) || grid[i][j] != 1 || visited[i][j] != null) {
            return 0;
        }
        visited[i][j] = key;
        int[] t = new int[2];
        t[0] = i;
        t[1] = j;
        list.add(t);
        int sum = 1;
        for (int[] ints : mask) {
            sum += dfs(i + ints[0], j + ints[1], key, list);
        }
        return sum;
    }

    private boolean out(int i, int j) {
        return i < 0 || i >= n || j < 0 || j >= n;
    }

    private int cal(int i, int j) {
        if (grid[i][j] != 0) {
            return grid[i][j];
        }
        int count = 1;
        Set<String> set = new HashSet<>();
        for (int[] m : mask) {
            int ii = i + m[0];
            int jj = j + m[1];
            if (!out(ii, jj) && !set.contains(visited[ii][jj])) {
                count += grid[ii][jj];
                set.add(visited[ii][jj]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 1}};
        // 4
        System.out.println(new LargestIsland827().largestIsland(grid));
    }
}
