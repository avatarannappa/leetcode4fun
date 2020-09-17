import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 140. 单词拆分 II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/17
 */
public class WordBreak140 {

    Set<String> set;
    List<String> result;
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return backTracking(s, 0);
    }

    public List<String> backTracking(String s, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(start, end))) {
                List<String> list = backTracking(s, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    public List<String> wordBreakOld(String s, List<String> wordDict) {
        // 超时
        set = new HashSet<>(wordDict);
        result = new ArrayList<>();
        backTrackingOld(s, new LinkedList<>());
        return result;
    }

    public void backTrackingOld(String s, LinkedList<String> list) {

        if (s == null || s.length() == 0) {
            StringBuilder sb = new StringBuilder();
            list.forEach(l -> sb.append(l).append(" "));
            result.add(sb.substring(0, sb.length() - 1));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (set.contains(str)) {
                LinkedList<String> newList = new LinkedList<>(list);
                newList.add(str);
                backTrackingOld(s.substring(i), newList);
            }
        }
    }

    public static void main(String[] args) {
        String s = "catsandcatsand";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(new WordBreak140().wordBreak(s, wordDict));
    }
}
