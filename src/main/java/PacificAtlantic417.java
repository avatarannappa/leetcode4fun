import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/4/27
 */
public class PacificAtlantic417 {

    int[][] height;
    int w;
    int h;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        this.height = heights;
        this.w = heights[0].length;
        this.h = heights.length;
        boolean[][] pacific = new boolean[h][w];
        boolean[][] atlantic = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 || j == 0) {
                    dfs(i, j, pacific, Integer.MIN_VALUE);
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == h - 1 || j == w - 1) {
                    dfs(i, j, atlantic, Integer.MIN_VALUE);
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j, boolean[][] visited, int prev) {
        if (i < 0 || i >= h || j < 0 || j >= w || visited[i][j] || height[i][j] < prev) {
            return;
        }
        visited[i][j] = true;
        for (int[] ints : dir) {
            dfs(i + ints[0], j + ints[1], visited, height[i][j]);
        }
    }

    public static void main(String[] args) {
        PacificAtlantic417 pacificAtlantic417 = new PacificAtlantic417();
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        // [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
        System.out.println(pacificAtlantic417.pacificAtlantic(heights));
    }
}
