/**
 * 953. 验证外星语词典 Verifying an Alien Dictionary.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/5/17
 */
public class IsAlienSorted953 {

    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i], map) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String a, String b, int[] map) {
        for (int i = 0, j = 0; i < a.length() && j < b.length(); i++, j++) {
            int aa = a.charAt(i) - 'a';
            int bb = b.charAt(j) - 'a';
            if (map[aa] != map[bb]) {
                return map[aa] - map[bb];
            }
        }
        return a.length() - b.length();
    }

    public static void main(String[] args) {
        IsAlienSorted953 isAlienSorted953 = new IsAlienSorted953();
        System.out.println(
            isAlienSorted953.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
