import java.util.Arrays;

/**
 * 1657. 确定两个字符串是否接近
 * medium
 *
 * @author avatarannappa
 * @date 2023/11/30
 */
public class CloseStrings1657 {

    public boolean closeStrings(String word1, String word2) {
        // Determine if Two Strings Are Close
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] == 0 && count2[i] != 0 || count1[i] != 0 && count2[i] == 0) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }

    public static void main(String[] args) {
        String word1 = "babzzcz";
        String word2 = "abbbzcf";
        // false
        System.out.println(new CloseStrings1657().closeStrings(word1, word2));
    }
}
