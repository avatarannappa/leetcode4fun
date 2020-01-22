import java.util.HashMap;
import java.util.Map;

/**
 * 168. Excel表列名称
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/23
 */
public class ConvertToTitle168 {
    private static Map<Integer, Character> dic = new HashMap<>();

    static {
        for (int i = 0; i < 26; i++) {
            dic.put(1 + i, (char) ('A' + i));
        }
        dic.put(0, 'Z');
    }

    public String convertToTitle(int n) {
        String result = "";
        while (n > 0) {
            int i = n % 26;
            char c = dic.get(i);
            result = c + result;
            if (n % 26 == 0) {
                n = n / 26 - 1;
            } else {
                n = n / 26;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ConvertToTitle168().convertToTitle(28));
    }
}
