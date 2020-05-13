import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/13
 */
public class FindAnagrams438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int pLen = p.length();
        for (int i = 0; i < s.length() - pLen + 1; i++) {
            String temp = s.substring(i, i + pLen);
            if (isAnagram(temp, p)) {
                result.add(i);
            }
        }

        return result;
    }

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
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new FindAnagrams438().findAnagrams(s, p));
    }
}
