import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 205. 同构字符串.
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/25
 */
public class IsIsomorphic205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);
            if (charMap.containsKey(sc)) {
                if (!charMap.get(sc).equals(tc)) {
                    return false;
                }
            } else {
                charMap.put(sc, tc);
            }
        }
        if (charMap.values().stream().distinct().collect(Collectors.toList()).size() != charMap.size()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        System.out.println(new IsIsomorphic205().isIsomorphic(s, t));
    }
}
