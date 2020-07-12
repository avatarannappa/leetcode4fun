/**
 * 211. 添加与搜索单词 - 数据结构设计.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/13
 */
public class WordDictionary211 {


    Trie trie = new Trie();

    /**
     * Initialize your data structure here.
     */
    public WordDictionary211() {

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        trie.insert(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return trie.search(word, trie);
    }

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
        public boolean search(String word, Trie trie) {
            if (word == null || word.length() == 0) {
                return false;
            }
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                boolean sign = false;

                if (word.charAt(i) == '.') {
                    if (i == word.length() - 1) {
                        for (Trie t : trie.next) {
                            if (t != null) {
                                sign |= t.end;
                            }
                        }
                    } else {
                        for (Trie t : trie.next) {
                            if (t != null) {
                                sign |= search(word.substring(i + 1), t);
                            }
                        }
                    }
                    return sign;
                } else if (trie.next[word.charAt(i) - 'a'] == null) {
                    return false;
                } else {
                    trie = trie.next[index];
                }

            }
            return trie.end;
        }

    }

    public static void main(String[] args) {
        String[] words = {"a", "a", "mad"};
        String[] searchs = {".", "b.."};
        WordDictionary211 wordDictionary = new WordDictionary211();
        for (String word : words) {
            wordDictionary.addWord(word);
        }
        for (String search : searchs) {
            System.out.println(wordDictionary.search(search));
        }
    }
}
