import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 890. 查找和替换模式.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/6/12
 */
public class FindAndReplacePattern890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new LinkedList<>();
        for (String word : words) {
            Map<Character, Character> map = new HashMap<>();
            Map<Character, Character> rMap = new HashMap<>();
            boolean sign = true;
            for (int i = 0; i < pattern.length(); i++) {
                char w = word.charAt(i);
                char p = pattern.charAt(i);
                if (!map.containsKey(w) && !rMap.containsKey(p)) {
                    map.put(w, p);
                    rMap.put(p, w);
                    continue;
                }
                if (map.getOrDefault(w, p) != p) {
                    sign = false;
                    break;
                }
                if (rMap.getOrDefault(p, w) != w) {
                    sign = false;
                    break;
                }
            }
            if (sign) {
                ans.add(word);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        // mee, aqq
        System.out.println(new FindAndReplacePattern890().findAndReplacePattern(words, pattern));
    }
}
