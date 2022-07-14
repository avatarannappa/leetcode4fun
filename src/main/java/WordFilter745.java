import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 745. 前缀和后缀搜索
 * hard
 *
 * @author avatarnnappa
 * @date 2022/7/14
 */
public class WordFilter745 {

    Map<String, List<Integer>> prefMap = new HashMap<>();
    Map<String, Set<Integer>> suffMap = new HashMap<>();

    public WordFilter745(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String pref = word.substring(0, j);
                String suff = word.substring(j);
                List<Integer> prefVal = prefMap.getOrDefault(pref, new LinkedList<>());
                prefVal.add(i);
                prefMap.put(pref, prefVal);
                Set<Integer> suffVal = suffMap.getOrDefault(suff, new HashSet<>());
                suffVal.add(i);
                suffMap.put(suff, suffVal);
            }
        }
    }

    public int f(String pref, String suff) {
        List<Integer> prefIndexSet = prefMap.getOrDefault(pref, new LinkedList<>());
        Set<Integer> suffIndexSet = suffMap.getOrDefault(suff, new HashSet<>());
        for (int i = prefIndexSet.size() - 1; i >= 0; i--) {
            if (suffIndexSet.contains(prefIndexSet.get(i))) {
                return prefIndexSet.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"a","a"};
        WordFilter745 wordFilter745 = new WordFilter745(words);
        System.out.println(wordFilter745.f("a", "a"));
    }
}
