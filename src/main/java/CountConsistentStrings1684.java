import java.util.HashSet;
import java.util.Set;

/**
 * 1684. 统计一致字符串的数目
 * easy
 *
 * @author avatarannappa
 * @date 2022/11/8
 */
public class CountConsistentStrings1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }

        int ans = 0;

        for (String word : words) {
            int j = 0;
            for (; j < word.length(); j++) {
                if (!set.contains(word.charAt(j))) {
                    break;
                }
            }
            if (j == word.length()) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
        // 输出：2
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        System.out.println(new CountConsistentStrings1684().countConsistentStrings(allowed, words));
    }
}
