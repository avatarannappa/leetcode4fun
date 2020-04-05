import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/5
 */
public class CanConstruct383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                if (count <= 0) {
                    return false;
                } else {
                    map.put(c, count - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(new CanConstruct383().canConstruct(ransomNote, magazine));
    }
}
