import java.util.HashSet;
import java.util.Set;

/**
 * 2506. 统计相似字符串对的数目
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2025/2/22
 */
public class SimilarPairs2506 {
    public int similarPairs(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (same(words[i], words[j])) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean same(String a, String b) {
        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            s1.add(a.charAt(i));
        }

        for (int j = 0; j < b.length(); j++) {
            s2.add(b.charAt(j));
        }

        if (s1.size() != s2.size()) {
            return false;
        }

        for (Character c : s1) {
            if (!s2.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
