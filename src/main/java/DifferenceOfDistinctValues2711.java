import java.util.HashSet;
import java.util.Set;

/**
 * 2711. 对角线上不同值的数量差.
 * medium
 *
 * @author avatarannappa
 * @version 2025/3/25
 */
public class DifferenceOfDistinctValues2711 {

    public int[][] differenceOfDistinctValues(int[][] grid) {
        // 暴力
        // TODO 前后缀和
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> set1 = new HashSet<>();
                int ii = i - 1;
                int jj = j - 1;
                while (ii >= 0 && jj >= 0) {
                    set1.add(grid[ii][jj]);
                    ii--;
                    jj--;
                }
                Set<Integer> set2 = new HashSet<>();
                ii = i + 1;
                jj = j + 1;
                while (ii < m && jj < n) {
                    set2.add(grid[ii][jj]);
                    ii++;
                    jj++;
                }
                result[i][j] = Math.abs(set2.size() - set1.size());
            }
        }

        return result;
    }

}
