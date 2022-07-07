import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 648. 单词替换
 * medium
 *
 * @author avatarannappa
 * @date 2022/7/7
 */
public class ReplaceWords648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort(Comparator.comparingInt(String::length));
        String[] array = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            boolean mark = false;
            for (String d : dictionary) {
                if (s.startsWith(d)) {
                    sb.append(d);
                    sb.append(" ");
                    mark = true;
                    break;
                }
            }
            if (!mark) {
                sb.append(s);
                sb.append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1).toString();
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        Collections.addAll(dictionary, "a", "aa", "aaa", "aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        // a a a a a a a a bbb baba a
        System.out.println(new ReplaceWords648().replaceWords(dictionary, sentence));
    }
}
