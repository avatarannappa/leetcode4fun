import com.google.common.collect.Sets;

import java.util.*;

/**
 * 500. 键盘行.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/12
 */
public class FindWords500 {

    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return words;
        }
        List<Character> list1 = Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
        List<Character> list2 = Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
        List<Character> list3 = Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm');
        Set<Character> set1 = new HashSet<>(list1);
        Set<Character> set2 = new HashSet<>(list2);
        Set<Character> set3 = new HashSet<>(list3);
        List<String> result = new ArrayList<>();
        for (String word : words) {
            int sign = 0;
            boolean in = true;
            String low = word.toLowerCase();
            for (char c : low.toCharArray()) {
                int temp = 0;
                if (set1.contains(c)) {
                    temp = 1;
                } else if (set2.contains(c)) {
                    temp = 2;
                } else if (set3.contains(c)) {
                    temp = 3;
                }
                if (sign == 0) {
                    sign = temp;
                } else {
                    if (sign != temp) {
                        in = false;
                    }
                }
            }
            if (in) {
                result.add(word);
            }
        }
        String[] r = new String[result.size()];
        return result.toArray(r);
    }

    public static void main(String[] args) {
        String[] words = {"Aasdfghjkl","Qwertyuiop","zZxcvbnm"};
        System.out.println(Arrays.toString(new FindWords500().findWords(words)));
    }
}
