import java.util.*;
import java.util.stream.Collectors;

/**
 * 395. 至少有K个重复字符的最长子串.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/23
 */
public class LongestSubstring395 {

    public int longestSubstring(String s, int k) {
        int max = 0;
        if (s == null || s.length() < k) {
            return max;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, (oldVal, newVal) -> oldVal + 1);
        }
        List<Character> list =
                map.entrySet().stream().filter(op -> op.getValue() < k).map(op -> op.getKey()).collect(Collectors.toList());
        if (list.size() == 0) {
            return s.length();
        }
        String splitStr = "";
        for (Character c : list) {
            splitStr += c + "|";
        }
        splitStr = splitStr.substring(0, splitStr.length() - 1);
        String[] array = s.split(splitStr);
        if (array.length == 0) {
            return max;
        }
        for (String str : array) {
            if (str.length() < k) {
                continue;
            } else {
                max = Math.max(max, longestSubstring(str, k));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "ababbcabaabb";
        int k = 2;
        System.out.println(new LongestSubstring395().longestSubstring(s, k));
    }
}
