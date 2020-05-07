import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/8
 */
public class Combine77 {

    List<List<Integer>> result = new ArrayList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        this.n = n;
        this.k = k;
        backTrack(1, new LinkedList<>());
        return result;
    }

    public void backTrack(int start, LinkedList<Integer> list) {
        if (list.size() == k) {
            result.add(new LinkedList<>(list));
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backTrack(i + 1, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(new Combine77().combine(n, k));
    }
}
