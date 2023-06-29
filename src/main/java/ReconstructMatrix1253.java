import java.util.LinkedList;
import java.util.List;

/**
 * 1253. 重构 2 行二进制矩阵
 * medium
 *
 * @author avatarannappa
 * @date 2023/6/29
 */
public class ReconstructMatrix1253 {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        // 模拟，贪心
        List<List<Integer>> res = new LinkedList<>();

        int n = colsum.length;

        int[] uArray = new int[n];
        int[] lArray = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int col = colsum[i];
            if (col == 2) {
                uArray[i] = 1;
                lArray[i] = 1;
                upper--;
                lower--;
            } else {
                sum += col;
            }
        }

        if (sum != upper + lower || upper < 0 || lower < 0) {
            return res;
        }

        for (int i = 0; i < n; i++) {
            if (uArray[i] == 1 || colsum[i] == 0) {
                continue;
            }
            if (upper > 0) {
                uArray[i] = 1;
                upper--;
            } else if (lower > 0) {
                lArray[i] = 1;
                lower--;
            } else {
                break;
            }
        }

        List<Integer> uList = new LinkedList<>();
        List<Integer> lList = new LinkedList<>();
        res.add(uList);
        res.add(lList);
        for (int i = 0; i < n; i++) {
            uList.add(uArray[i]);
            lList.add(lArray[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int upper = 5, lower = 5;
        int[] colsum = {2, 1, 2, 0, 1, 0, 1, 2, 0, 1};
        System.out.println(new ReconstructMatrix1253().reconstructMatrix(upper, lower, colsum));
    }
}
