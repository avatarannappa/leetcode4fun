/**
 * 676. 实现一个魔法字典
 * medium
 *
 * @author avatarannappa
 * @date 2024/8/12
 */
public class MagicDictionary676 {

    String[] dictionary;

    public MagicDictionary676() {

    }

    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public boolean search(String searchWord) {
        // 暴力
        for (String word : dictionary) {
            if (equal(word, searchWord)) {
                return true;
            }
        }
        return false;
    }

    private boolean equal(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

}
