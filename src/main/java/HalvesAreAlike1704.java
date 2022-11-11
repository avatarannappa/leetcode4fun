import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1704. 判断字符串的两半是否相似
 * easy
 *
 * @author avatarannappa
 * @date 2022/11/11
 */
public class HalvesAreAlike1704 {

    public boolean halvesAreAlike(String s) {
        int half = s.length() / 2;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int lc = 0;
        int rc = 0;
        for (int l = 0, r = s.length() - 1; l < half; l++, r--) {
            if (set.contains(s.charAt(l))) {
                lc++;
            }
            if (set.contains(s.charAt(r))) {
                rc++;
            }
        }

        return lc == rc;
    }

    public static void main(String[] args) {
        String s = "AbCdEfGh";
        // true
        System.out.println(new HalvesAreAlike1704().halvesAreAlike(s));
    }
}
