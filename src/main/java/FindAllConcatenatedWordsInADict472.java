import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 472. 连接词.
 * hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/10
 */
public class FindAllConcatenatedWordsInADict472 {

    Trie trie = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // trie + dfs
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            if (dfs(word, 0)) {
                ans.add(word);
            } else {
                insert(word);
            }
        }

        return ans;
    }

    private void insert(String word) {
        Trie node = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean dfs(String word, int start) {
        if (word.length() == start) {
            return true;
        }
        Trie node = trie;
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            node = node.children[index];
            if (node == null) {
                return false;
            }
            if (node.isEnd && dfs(word, i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static class Trie {

        Trie[] children;
        boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        // 输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
        System.out.println(new FindAllConcatenatedWordsInADict472().findAllConcatenatedWordsInADict(words));
    }
}
