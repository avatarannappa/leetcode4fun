import java.util.HashSet;
import java.util.Set;

/**
 * 2744. 最大字符串配对数目
 * easy
 *
 * @author avatarannappa
 * @date 2024/1/17
 */
public class MaximumNumberOfStringPairs2744 {

    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>();

        int cnt = 0;
        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (set.contains(reverse)) {
                cnt++;
            }
            set.add(word);
        }
        return cnt;
    }

}
