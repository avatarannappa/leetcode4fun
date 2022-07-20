import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * easy
 *
 * @author avatarannappa
 * @date 2022/7/20
 */
public class ShiftGrid1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = m * n;
        k = k % mod;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = (i * n + j + k) % mod;
                int ii = temp / n;
                int jj = temp % n;
                arr[ii][jj] = grid[i][j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(arr[i][j]);
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        int k = 4;
        // [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
        System.out.println(new ShiftGrid1260().shiftGrid(grid, k));
    }
}
