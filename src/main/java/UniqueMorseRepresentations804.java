import java.util.HashSet;
import java.util.Set;

/**
 * 804. 唯一摩尔斯密码词
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/7
 */
public class UniqueMorseRepresentations804 {

    String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morseCode[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(new UniqueMorseRepresentations804().uniqueMorseRepresentations(words));
    }
}
