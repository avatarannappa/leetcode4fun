/**
 * 3142. 判断矩阵是否满足条件.
 * easy
 *
 * @author avatarannappa
 * @date 2024/8/29
 */
public class SatisfiesConditions3142 {

    public boolean satisfiesConditions(int[][] grid) {
        // 简单模拟
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
                if (j + 1 < n && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
