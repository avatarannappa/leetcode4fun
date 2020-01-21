/**
 * 242. 有效的字母异位词
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/21
 */
public class IsAnagram242 {

    public boolean isAnagram(String s, String t) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            array[index] = array[index] + 1;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int index = c - 'a';
            array[index] = array[index] - 1;
        }
        for (int i : array) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new IsAnagram242().isAnagram(s, t));
    }
}
