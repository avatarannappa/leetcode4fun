import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * 720. 词典中最长的单词.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/18
 */
public class LongestWord720 {
    public String longestWord(String[] words) {
        // trie树，不想写
        String ans = "";
        Set<String> set = new TreeSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String str = word.substring(0, i + 1);
                if (!set.contains(str)) {
                    break;
                }
                if (str.length() > ans.length()) {
                    ans = str;
                } else if (str.length() == ans.length()) {
                    ans = ans.compareTo(str) < 0 ? ans : str;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        System.out.println(new LongestWord720().longestWord(words));
    }
}
