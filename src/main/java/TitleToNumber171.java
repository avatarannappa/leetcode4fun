import java.util.HashMap;
import java.util.Map;

/**
 * 171. Execel表序列号
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/19
 */
public class TitleToNumber171 {

    private static Map<Character, Integer> dic = new HashMap<>();

    static {
        for (int i = 0; i < 26; i++) {
            dic.put((char) ('A' + i), 1 + i);
        }
    }

    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + dic.get(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TitleToNumber171().titleToNumber("AB"));
    }

}
