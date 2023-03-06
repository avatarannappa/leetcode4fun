import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 851. 喧闹和富有
 * medium
 *
 * @author avatarannappa
 * @date 2023/3/6
 */
public class LoudAndRich851 {

    Map<Integer, List<Integer>> adMap = new HashMap<>();

    private void add(int a, int b) {
        List<Integer> list = adMap.getOrDefault(a, new LinkedList<>());
        list.add(b);
        adMap.put(a, list);
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int n = quiet.length;
        int[] in = new int[n];
        for (int[] r : richer) {
            int a = r[0], b = r[1];
            add(a, b);
            in[b]++;
        }

        int[] ans = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            ans[i] = i;
            if (in[i] == 0) {
                deque.addLast(i);
            }
        }
        while (!deque.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            while (!deque.isEmpty()) {
                int a = deque.pollFirst();
                List<Integer> l = adMap.getOrDefault(a, new LinkedList<>());
                for (Integer b : l) {
                    if (quiet[ans[a]] < quiet[ans[b]]) {
                        ans[b] = ans[a];
                    }
                    if (--in[b] == 0) {
                        temp.add(b);
                    }
                }
            }
            deque.addAll(temp);
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
//        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        // {5,5,2,5,4,5,6,7}
        int[][] richer = {{0, 2}, {1, 2}};
        int[] quiet = {0, 1, 2};
        System.out.println(Arrays.toString(new LoudAndRich851().loudAndRich(richer, quiet)));
    }
}
