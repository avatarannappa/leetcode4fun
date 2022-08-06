import java.util.LinkedList;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/6
 */
public class StringMatching1408 {
    public List<String> stringMatching(String[] words) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};
        System.out.println(new StringMatching1408().stringMatching(words));
    }
}
