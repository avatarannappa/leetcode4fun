import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/28
 */
public class ReverseVowels345 {

    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int start = 0;
        int end = s.length() - 1;

        char[] array = s.toCharArray();
        while (start <= end) {
            if (set.contains(array[start])) {
                if (set.contains(array[end])) {
                    char temp = array[start];
                    array[start] = array[end];
                    array[end] = temp;
                    start++;
                    end--;
                } else {
                    end--;
                }
            } else {
                start++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(new ReverseVowels345().reverseVowels(s));
    }
}
