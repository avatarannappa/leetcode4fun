import java.util.*;

/**
 * 3025. 人员站位的方案数 I.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2025/9/2
 */
public class NumberOfPairs3025 {

    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> b[1] - a[1] == 0 ? a[0] - b[0] : b[1] - a[1]);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i < points.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < i; j++) {
                if (fit(points[j], points[i])) {
                    set.add(j);
                    set.removeAll(map.getOrDefault(j, new HashSet<>()));
                }
            }
            map.put(i, set);
        }
        int res = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> set = entry.getValue();
            res += set.size();
        }
        return res;
    }

    public boolean fit(int[] a, int[] b) {
        if (a[0] == b[0] || a[1] == b[1]) {
            return true;
        } else if (a[0] < b[0]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // 输入：points = [[6,2],[4,4],[2,6]]
        // [[2,4],[4,2],[0,2]]
        // 输出：2
        int[][] points = {{0, 5}, {2, 5}, {3, 1}, {1, 4}};
        System.out.println(new NumberOfPairs3025().numberOfPairs(points));
    }
}
