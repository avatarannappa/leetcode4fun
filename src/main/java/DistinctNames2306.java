import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2306. 公司命名.
 * hard
 *
 * @author avatarannappa
 * @version 2024/9/25
 */
public class DistinctNames2306 {

    public long distinctNames(String[] ideas) {
        // 首字母分类，计算value差集
        Map<Character, Set<String>> map = new HashMap<>();
        for (String idea : ideas) {
            char first = idea.charAt(0);
            map.computeIfAbsent(first, k -> new HashSet<>()).add(idea.substring(1));
        }
        long res = 0;
        for (Map.Entry<Character, Set<String>> entry1 : map.entrySet()) {
            for (Map.Entry<Character, Set<String>> entry2 : map.entrySet()) {
                if (entry1.getKey().equals(entry2.getKey())) {
                    continue;
                }
                Set<String> set1 = entry1.getValue();
                Set<String> set2 = entry2.getValue();
                res += getCnt(set1, set2);
            }
        }

        return res;
    }

    private int getCnt(Set<String> set1, Set<String> set2) {
        int cnt = 0;

        for (String s1 : set1) {
            if (set2.contains(s1)) {
                cnt++;
            }
        }

        return (set1.size() - cnt) * (set2.size() - cnt);
    }

    public static void main(String[] args) {
        String[] ideas = {"aaa", "baa", "caa", "bbb", "cbb", "dbb"};
        // 6
        System.out.println(new DistinctNames2306().distinctNames(ideas));
    }

}
