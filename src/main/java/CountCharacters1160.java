import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1160. 拼写单词.
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/17
 */
public class CountCharacters1160 {

    public int countCharacters(String[] words, String chars) {
        int[] ab = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            int index = chars.charAt(i) - 'a';
            ab[index] += 1;
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean exit = true;
            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'a';
                ab[index] -= 1;
                if (ab[index] < 0) {
                    exit =false;
                }
            }
            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'a';
                ab[index] += 1;
            }
            if (exit) {
                count += word.length();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(new CountCharacters1160().countCharacters(words, chars));
    }
}
