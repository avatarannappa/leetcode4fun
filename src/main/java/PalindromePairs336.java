import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 336. 回文对.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/5
 */
public class PalindromePairs336 {

    public List<List<Integer>> palindromePairs(String[] words) {
        // O(n*(words.length**2))
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(reverseString(words[i]), i);
        }

        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String prefix = words[i].substring(0, j);
                String postfix = words[i].substring(j);
                if (isPalindrome(postfix)) {
                    if (map.containsKey(prefix) && map.get(prefix) != i) {
                        ans.add(Stream.of(i, map.get(prefix)).collect(Collectors.toList()));
                    }
                }
                if (isPalindrome(prefix)) {
                    if (map.containsKey(postfix) && map.get(postfix) != i) {
                        ans.add(Stream.of(map.get(postfix), i).collect(Collectors.toList()));
                    }
                }
            }
        }

        return new LinkedList<>(ans);
    }

    public String reverseString(String origin) {
        return new StringBuilder(origin).reverse().toString();
    }

    public boolean isPalindrome(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != a.charAt(a.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> palindromePairsOld(String[] words) {
        // 超时 134 / 135 个通过测试用例
        // O(n**2*words.length)
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String whole = words[i] + words[j];
                String reverseWhole = words[j] + words[i];
                if (isPalindrome(whole)) {
                    ans.add(Stream.of(i, j).collect(Collectors.toList()));
                }
                if (isPalindrome(reverseWhole)) {
                    ans.add(Stream.of(j, i).collect(Collectors.toList()));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = { "a", "aa" };
        // [[0,1],[1,0],[3,2],[2,4]]
        System.out.println(new PalindromePairs336().palindromePairs(words));
    }
}
