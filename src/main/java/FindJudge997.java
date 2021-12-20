import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 997. 找到小镇的法官.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/19
 */
public class FindJudge997 {

    public int findJudge(int n, int[][] trust) {
        int ans = -1;
        if (trust.length == 0 && n == 1) {
            return 1;
        }

        Map<Integer, Set<Integer>> trusted = new HashMap<>();
        Map<Integer, Integer> trustee = new HashMap<>();
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            Set<Integer> set = trusted.getOrDefault(b, new HashSet<>());
            set.add(a);
            trusted.put(b, set);
            trustee.put(a, b);
        }
        for (Map.Entry<Integer, Set<Integer>> en : trusted.entrySet()) {
            if (en.getValue().size() == n - 1 && !trustee.containsKey(en.getKey())) {
                ans = en.getKey();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(new FindJudge997().findJudge(n, trust));
    }
}
