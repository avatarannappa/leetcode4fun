import java.util.*;
import java.util.stream.Collectors;

/**
 * 2975. 移动栅栏得到的正方形田地的最大面积.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2026/1/16
 */
public class MaximizeSquareArea2975 {

    int mod = 10_0000_0007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        Set<Integer> h = cal(m, hFences);
        Set<Integer> v = cal(n, vFences);
        List<Integer> hl = h.stream().sorted().collect(Collectors.toList());
        List<Integer> vl = v.stream().sorted().collect(Collectors.toList());
        int i = h.size() - 1;
        int j = v.size() - 1;
        while (i >= 0 && j >= 0) {
            if (hl.get(i).equals(vl.get(j))) {
                return (int) ((long) hl.get(i) * (long) vl.get(j) % mod);
            } else if (hl.get(i) > vl.get(j)) {
                i--;
            } else {
                j--;
            }
        }
        return -1;
    }

    private Set<Integer> cal(int m, int[] fences) {
        Set<Integer> v = new HashSet<>();
        v.add(m - 1);
        for (int i = 0; i < fences.length; i++) {
            int v1 = fences[i];
            v.add(v1 - 1);
            v.add(m - v1);
            for (int j = i + 1; j < fences.length; j++) {
                int v2 = fences[j];
                v.add(v2 - v1);
            }
        }
        return v;
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 6;
        int[] hFences = {4, 2, 3};
        int[] vFences = {4, 5};
        // 16
        System.out.println(new MaximizeSquareArea2975().maximizeSquareArea(m, n, hFences, vFences));
    }
}
