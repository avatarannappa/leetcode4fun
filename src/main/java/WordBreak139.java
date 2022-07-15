import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/30
 */
public class WordBreak139 {

    Set<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        set = new LinkedHashSet<>(wordDict);
        return recursion(s, 0, new Boolean[s.length()]);
    }

    public boolean recursion(String s, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (set.contains(s.substring(start, i))) {
                if (recursion(s, i, memo)) {
                    return memo[start] = true;
                }
            }
        }
        return memo[start] = false;
    }

    public boolean recursionOld(String s) {
        // 超时 n^n
        if (s == null || s.length() == 0) {
            return true;
        }

        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            temp += s.charAt(i);
            boolean sign = false;
            if (set.contains(temp)) {
                if (i + 1 == s.length()) {
                    sign = true;
                } else {
                    sign = recursionOld(s.substring(i + 1, s.length()));
                }
                if (sign) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] array = {"a", "abc", "b", "cd"};
        String s = "abcd";
        List<String> wordDict = Arrays.asList(array);
        System.out.println(new WordBreak139().wordBreak(s, wordDict));
    }

}
