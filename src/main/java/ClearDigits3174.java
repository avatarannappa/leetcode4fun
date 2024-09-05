import java.util.LinkedList;
import java.util.List;

/**
 * 3174. 清除数字.
 * easy
 *
 * @author avatarannappa
 * @version 2024/9/5
 */
public class ClearDigits3174 {

    public String clearDigits(String s) {
        List<Character> l = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                l.remove(l.size() - 1);
            } else {
                l.add(c);
            }
        }

        StringBuilder res = new StringBuilder();
        for (Character c : l) {
            res.append(c);
        }
        return res.toString();
    }
}
