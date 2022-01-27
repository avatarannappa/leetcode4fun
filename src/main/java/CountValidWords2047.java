/**
 * 2047. 句子中的有效单词数.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/27
 */
public class CountValidWords2047 {

    public int countValidWords(String sentence) {
        String[] array = sentence.split(" ");
        int ans = 0;
        for (String word : array) {
            if (effectWord(word)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean effectWord(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= '0' && c <= '9') {
                return false;
            } else if (c >= 'a' && c <= 'z') {
                continue;
            } else if (c == '-') {
                count++;
                if (count > 1 || i == 0 || i == word.length() - 1) {
                    return false;
                } else {
                    if (word.charAt(i - 1) >= 'a' && word.charAt(i - 1) <= 'z' && word.charAt(i + 1) >= 'a'
                        && word.charAt(i + 1) <= 'z') {
                        continue;
                    } else {
                        return false;
                    }
                }
            } else {
                if (i != word.length() - 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
