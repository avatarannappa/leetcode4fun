import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/17
 */
public class LengthOfLongestSubstringOffer48 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            if (s.length() - i < result) {
                break;
            }
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    break;
                }
                set.add(c);
            }
            result = Math.max(result, set.size());
        }

        return result;
    }

    public int lengthOfLongestSubstringNew(String s) {
        // 记录重复的下标，少回溯一些
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            if (s.length() - i < result) {
                break;
            }
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    i = Math.max(map.get(c), i);
                    break;
                }
                map.put(c, j);
            }
            result = Math.max(result, map.size());
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "wpwkew";
        System.out.println(new LengthOfLongestSubstringOffer48().lengthOfLongestSubstring(s));
    }
}
