/**
 * 208. 实现 Trie (前缀树)
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/21
 */
public class Trie {

    private Trie[] next;
    private boolean end = false;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        next = new Trie[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() < 1) {
            return;
        }
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (root.next[index] == null) {
                Trie t = new Trie();
                root.next[index] = t;
            }
            root = root.next[index];
        }
        root.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (root.next[index] == null) {
                return false;
            }
            root = root.next[index];
        }
        return root.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie root = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (root.next[index] == null) {
                return false;
            }
            root = root.next[index];
        }
        return true;
    }
}
