import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 318. 最大单词长度乘积
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/10
 */
public class MaxProduct318 {

    public int maxProduct(String[] words) {
        int max = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            char[] arr = words[i].toCharArray();
            for (char s : arr) {
                set.add(s);
            }
            for (int j = i + 1; j < words.length; j++) {
                char[] arrJ = words[j].toCharArray();
                boolean sign = true;
                for (char c : arrJ) {
                    if (set.contains(c)) {
                        sign = false;
                        break;
                    }
                }
                if (sign && arr.length * arrJ.length > max) {
                    max = arr.length * arrJ.length;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        // 16
        System.out.println(new MaxProduct318().maxProduct(words));
    }
}
