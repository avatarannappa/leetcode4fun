import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串.
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/24
 */
public class LongestPalindrome409 {

    public int longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) % 2 == 1) {
                    count += 2;
                }
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Integer value : map.values()) {
            if (value % 2 == 1) {
                count++;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "ccccdd";
        System.out.println(new LongestPalindrome409().longestPalindrome(s));
    }
}
