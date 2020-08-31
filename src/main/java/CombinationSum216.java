import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/31
 */
public class CombinationSum216 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        recursion(new ArrayList<>(), k, n, 1);
        return result;
    }

    public void recursion(List<Integer> list, int k, int n, int index) {
        if (k == 0 && n == 0) {
            result.add(list);
        } else if (k == 0) {
            return;
        } else if (n == 0) {
            return;
        } else if (index > 9) {
            return;
        }
        for (int j = index; j <= 9; j++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(j);
            recursion(newList, k - 1, n - j, j + 1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 15;
        System.out.println(new CombinationSum216().combinationSum3(k, n));
    }
}
