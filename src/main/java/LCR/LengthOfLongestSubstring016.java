package LCR;

import java.util.HashMap;
import java.util.Map;

/**
 * LCR 016. 无重复字符的最长子串.
 * medium
 *
 * @author avatarannappa
 * @version 2025/3/14
 */
public class LengthOfLongestSubstring016 {

    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        int n = s.length();
        int l = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                len = Math.max(len, map.size());
                int preIndex = map.get(c);
                for (; l <= preIndex; l++) {
                    map.remove(s.charAt(l));
                }
                map.put(c, i);
            } else {
                map.put(c, i);
            }
        }
        len = Math.max(len, map.size());
        return len;
    }
    
}
