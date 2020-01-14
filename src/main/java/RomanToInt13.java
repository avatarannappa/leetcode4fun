import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/25
 */
public class RomanToInt13 {
    public static Map<Character, Integer> map = new LinkedHashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {

        Integer result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 >= s.length()) {
                result += map.get(s.charAt(i));
                continue;
            }
            char p = s.charAt(i);
            char n = s.charAt(i + 1);
            if (before(p, n)) {
                result += map.get(n) - map.get(p);
                i++;
            } else {
                result += map.get(p);
            }
        }
        return result;
    }

    private boolean before(char p, char n) {
        if (map.get(p) < map.get(n)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInt13().romanToInt("MCMXCIV"));
    }
}
