import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 884. 两句话中的不常见单词.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/30
 */
public class UncommonFromSentences884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> list = new LinkedList<>();

        String[] a1 = s1.split(" ");
        Map<String, Integer> m1 = new HashMap<>();
        for (String s : a1) {
            m1.put(s, m1.getOrDefault(s, 0) + 1);
        }
        String[] a2 = s2.split(" ");
        Map<String, Integer> m2 = new HashMap<>();
        for (String s : a2) {
            m2.put(s, m2.getOrDefault(s, 0) + 1);
        }
        for (Entry<String, Integer> entry : m1.entrySet()) {
            if (entry.getValue() > 1) {
                continue;
            }
            if (m2.containsKey(entry.getKey())) {
                continue;
            }
            list.add(entry.getKey());
        }
        for (Entry<String, Integer> entry : m2.entrySet()) {
            if (entry.getValue() > 1) {
                continue;
            }
            if (m1.containsKey(entry.getKey())) {
                continue;
            }
            list.add(entry.getKey());
        }
        
        String[] ans = new String[list.size()];
        return list.toArray(ans);
    }

    public static void main(String[] args) {
        String s1 = "this apple is sweet sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(new UncommonFromSentences884().uncommonFromSentences(s1, s2)));
    }

}
