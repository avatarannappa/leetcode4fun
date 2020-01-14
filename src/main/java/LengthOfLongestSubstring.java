import java.util.HashMap;
import java.util.Map;

/**
 * @author avatarannappa
 * @version 1.0, 2018/12/19
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "asdfasdfwasdf";
        System.out.println(lengthOfLongestSubstring(str));
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
}
