import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2982. 找出出现至少三次的最长特殊子字符串 II
 * medium
 *
 * @author avatarannappa
 * @date 2024/5/30
 */
public class MaximumLength2982 {

    public int maximumLength(String s) {
        int res = -1;
        int n = s.length();
        // 分组26个字母讨论
        Map<Character, List<Integer>> map = new HashMap<>();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            int len = 1;
            i++;
            while (i < n && s.charAt(i) == c) {
                i++;
                len++;
            }
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(len);
            map.put(c, list);
        }

        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            char c = entry.getKey();
            List<Integer> list = entry.getValue();
            list.sort(Comparator.reverseOrder());
            if (list.size() == 1) {
                if (list.get(0) < 3) {
                    continue;
                }
                res = Math.max(res, list.get(0) - 2);
            } else if (list.size() == 2) {
                if (list.get(0) < 2) {
                    continue;
                }
                if (list.get(0).equals(list.get(1))) {
                    res = Math.max(res, list.get(0) - 1);
                } else {
                    res = Math.max(res, Math.max(list.get(0) - 2, list.get(1)));
                }
            } else {
                if (list.get(0).equals(list.get(1)) && list.get(1).equals(list.get(2))) {
                    res = Math.max(res, list.get(0));
                } else if (list.get(0).equals(list.get(1))) {
                    res = Math.max(res, list.get(1) - 1);
                } else {
                    res = Math.max(res, Math.max(list.get(0) - 2, list.get(1)));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "aaaa";
        // 2
        System.out.println(new MaximumLength2982().maximumLength(s));
    }
}
