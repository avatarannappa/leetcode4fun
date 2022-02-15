import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1380. 矩阵中的幸运数.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/2/15
 */
public class Luckynumbers1380 {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int rowVal = row.getOrDefault(i, Integer.MAX_VALUE);
                rowVal = Math.min(rowVal, matrix[i][j]);
                row.put(i, rowVal);
                int colVal = col.getOrDefault(j, 0);
                colVal = Math.max(colVal, matrix[i][j]);
                col.put(j, colVal);
            }
        }
        row.entrySet().forEach(entry -> {
            if (col.containsValue(entry.getValue())) {
                ans.add(entry.getValue());
            }
        });

        return ans;
    }

    public static void main(String[] args) {
        // int[][] matrix = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        int[][] matrix = {{3,6},{7,1},{5,2},{4,8}};
        System.out.println(new Luckynumbers1380().luckyNumbers(matrix));
    }

}
