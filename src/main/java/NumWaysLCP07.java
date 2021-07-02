import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LCP 07. 传递信息
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/7/2
 */
public class NumWaysLCP07 {

    Map<Integer, List<int[]>> map = new HashMap<>();
    int end;
    int res;

    public int numWays(int n, int[][] relation, int k) {
        this.end = n - 1;
        for (int[] ints : relation) {
            List<int[]> l = map.getOrDefault(ints[0], new ArrayList<>());
            l.add(ints);
            map.put(ints[0], l);
        }
        recusion(0, k);
        return res;
    }

    public void recusion(int now, int k) {
        if (k == 0) {
            return;
        }
        List<int[]> l = map.get(now);
        if (l == null || l.size() == 0) {
            return;
        }
        for (int[] ints : l) {
            if (ints[1] == end && k == 1) {
                res++;
            } else {
                if (ints[1] != now) {
                    recusion(ints[1], k - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        int k = 3;
        //        int n = 3;
        //        int[][] relation = {{0, 2}, {2, 1}};
        //        int k = 2;
        System.out.println(new NumWaysLCP07().numWays(n, relation, k));
    }
}
