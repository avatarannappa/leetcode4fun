import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/20
 */
public class WordPattern290 {

    public boolean wordPattern(String pattern, String str) {
        char[] patternArray = pattern.toCharArray();
        String[] strArray = str.split(" ");
        if (patternArray.length != strArray.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map1 = new HashMap<>();
        for (int i = 0; i < patternArray.length; i++) {
            char c = patternArray[i];
            String s = strArray[i];
            if (map.containsKey(c)) {
                String ns = map.get(c);
                if (!ns.equals(s)) {
                    return false;
                }
            } else {
                map.put(c, s);
            }

            if (map1.containsKey(s)) {
                char nc = map1.get(s);
                if (c != nc) {
                    return false;
                }
            } else {
                map1.put(s, c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abcd";
        String str = "dog cat cat dog";
        System.out.println(new WordPattern290().wordPattern(pattern, str));
    }
}
