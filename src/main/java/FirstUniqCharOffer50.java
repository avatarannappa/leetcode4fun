import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/15
 */
public class FirstUniqCharOffer50 {

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        Set<Character> set = new LinkedHashSet<>();
        Set<Character> exist = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (exist.contains(c)) {
                continue;
            } else if (set.contains(c)) {
                set.remove(c);
                exist.add(c);
            } else {
                set.add(c);
            }
        }
        char c = set.isEmpty() ? ' ' : (char) set.toArray()[0];
        return c;
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(new FirstUniqCharOffer50().firstUniqChar(s));
    }
}
