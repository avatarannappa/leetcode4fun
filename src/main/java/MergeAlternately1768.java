/**
 * 1768. 交替合并字符串
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/23
 */
public class MergeAlternately1768 {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (i == j) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
        }

        if (i == word1.length()) {
            while (j < word2.length()) {
                sb.append(word2.charAt(j++));
            }
        }
        if (j == word2.length()) {
            while (i < word1.length()) {
                sb.append(word1.charAt(i++));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        // qpbqcr
        System.out.println(new MergeAlternately1768().mergeAlternately(word1, word2));
    }
}
