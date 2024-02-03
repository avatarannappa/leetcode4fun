import java.util.LinkedList;
import java.util.List;

/**
 * 2788. 按分隔符拆分字符串
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2024/02/03
 */
public class SplitWordsBySeparator2788 {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new LinkedList<>();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String temp = "";
                while (i < word.length() && word.charAt(i) != separator) {
                    temp += word.charAt(i);
                    i++;
                }
                if (temp.length() > 0) {
                    res.add(temp);
                }
            }
        }

        return res;
    }

}

