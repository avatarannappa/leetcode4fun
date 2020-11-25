import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1370. 上升下降字符串
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/25
 */
public class SortString1370 {

    public String sortString(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        List<Character> list = new LinkedList<>(map.keySet());
        StringBuilder sb = new StringBuilder();
        boolean sign = true;
        while (sb.length() < s.length()) {
            if (sign) {
                for (int i = 0; i < list.size(); i++) {
                    char c = list.get(i);
                    if (map.get(c) > 0) {
                        sb.append(c);
                        map.put(c, map.get(c) - 1);
                    }
                }
                sign = false;
            } else {
                for (int i = list.size() - 1; i >= 0; i--) {
                    char c = list.get(i);
                    if (map.get(c) > 0) {
                        sb.append(c);
                        map.put(c, map.get(c) - 1);
                    }
                }
                sign = true;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new SortString1370().sortString(s));
    }
}
