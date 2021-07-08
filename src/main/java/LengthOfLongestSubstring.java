import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2018/12/19
 * 1.1 2021/07/07 滑动窗口
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(lengthOfLongestSubstring2(str));
    }

    static int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            Map<Character, Character> tempMap = new HashMap<Character, Character>();
            int tempLen = 0;
            for (int j = i; j < array.length; j++) {
                if (tempMap.containsKey(array[j])) {
                    break;
                }
                tempMap.put(array[j], array[j]);
                tempLen++;
            }

            if (tempLen > max) {
                max = tempLen;
            }
        }
        return max;
    }

    static int lengthOfLongestSubstring2(String s) {
        // 滑动窗口
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)));
                map.remove(s.charAt(i));
            }
            max = Math.max(max, i - left);
            map.put(s.charAt(i), i);
        }
        return max;
    }
}
