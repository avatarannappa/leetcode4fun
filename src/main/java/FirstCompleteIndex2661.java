import java.util.HashMap;
import java.util.Map;

/**
 * 2661. 找出叠涂元素 First Completely Painted Row or Column
 * medium
 *
 * @author avatarannappa
 * @date 2023/12/1
 */
public class FirstCompleteIndex2661 {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // 模拟计数
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        int[] col = new int[m];
        int[] row = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int[] ind = map.get(arr[i]);
            col[ind[0]]++;
            row[ind[1]]++;
            if (col[ind[0]] == n || row[ind[1]] == m) {
                return i;
            }
        }
        return arr.length - 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};
        int[][] mat = {{1, 4}, {2, 3}};
        // 2
        System.out.println(new FirstCompleteIndex2661().firstCompleteIndex(arr, mat));
    }
}
