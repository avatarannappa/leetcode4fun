import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/10
 */
public class PermutationOffer38 {

    List<String> result = new ArrayList<>();
    char[] array;

    public String[] permutation(String s) {

        if (s == null || s.length() == 0) {
            return new String[0];
        }
        array = s.toCharArray();
        backTracking(0);
        return result.toArray(new String[0]);
    }

    public void backTracking(int index) {
        if (index == array.length - 1) {
            result.add(String.valueOf(array));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (set.contains(array[i])) {
                continue;
            }
            set.add(array[i]);
            swap(index, i);
            backTracking(index + 1);
            swap(i, index);
        }
    }

    public void swap(int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(Arrays.toString(new PermutationOffer38().permutation(s)));
    }
}
