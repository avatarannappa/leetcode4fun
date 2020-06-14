import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 187. 重复的DNA序列.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/14
 */
public class FindRepeatedDnaSequences187 {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return list;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            if (map.containsKey(str)) {
                set.add(str);
            } else {
                map.put(str, 1);
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        System.out.println(new FindRepeatedDnaSequences187().findRepeatedDnaSequences(s));
    }
}
