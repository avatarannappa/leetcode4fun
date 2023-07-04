import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 2679. 矩阵中的和
 * medium
 *
 * @author avatarannappa
 * @date 2023/7/4
 */
public class MatrixSum2679 {

    public int matrixSum(int[][] nums) {
        int ans = 0;

        List<List<Integer>> list = new LinkedList<>();
        for (int[] num : nums) {
            List<Integer> temp = new LinkedList<>();
            for (int i : num) {
                temp.add(i);
            }
            temp.sort(Comparator.reverseOrder());
            list.add(temp);
        }

        for (int i = 0; i < list.get(0).size(); i++) {
            int max = 0;
            for (List<Integer> inner : list) {
                max = Math.max(inner.get(i), max);
            }
            ans += max;
        }

        return ans;
    }

    public static void main(String[] args) {
        // 输入：nums = [[7,2,1],[6,4,2],[6,5,3],[3,2,1]]
        // 输出：15
        int[][] nums = {{7, 2, 1}, {6, 4, 2}, {6, 5, 3}, {3, 2, 1}};
        System.out.println(new MatrixSum2679().matrixSum(nums));
    }
}
