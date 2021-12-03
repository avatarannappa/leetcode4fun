import java.util.HashSet;
import java.util.Set;

/**
 * 859. 亲密字符串.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/3
 */
public class BuddyStrings859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        char firstChar1 = ' ';
        char firstChar2 = ' ';
        int firstIndex = -1;
        int secondIndex = -1;
        Set<Character> set = new HashSet<>();
        boolean repeat = false;
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char gg = goal.charAt(i);
            if (ss != gg) {
                if (secondIndex != -1) {
                    return false;
                } else if (firstIndex != -1) {
                    if (firstChar1 == gg && firstChar2 == ss) {
                        secondIndex = i;
                    } else {
                        return false;
                    }
                } else {
                    firstChar1 = ss;
                    firstChar2 = gg;
                    firstIndex = i;
                }
            } else {
                if (set.contains(ss)) {
                    repeat = true;
                }
                set.add(ss);
            }
        }
        if (firstIndex == -1) {
            return repeat;
        }
        return secondIndex != -1;
    }
}
