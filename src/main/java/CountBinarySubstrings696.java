import java.util.LinkedList;
import java.util.List;

/**
 * 696. 计数二进制子串.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/11
 */
public class CountBinarySubstrings696 {

    public int countBinarySubstrings(String s) {
        int result = 0;
        if (s == null || s.length() < 2) {
            return result;
        }
        List<Integer> list = new LinkedList<>();
        char[] array = s.toCharArray();
        char pre = array[0];
        int temp = 1;
        int index =0;
        for (int i = 1; i < array.length; i++) {
            char c = array[i];
            if (c == pre) {
                temp++;
            } else {
                list.add(temp);
                if (index > 0) {
                    result += Math.min(list.get(index), list.get(index - 1));
                }
                index++;
                temp = 1;
                pre = c;
            }
        }
        list.add(temp);
        if (list.size() > 1) {
            result += Math.min(list.get(index), list.get(index - 1));
        }

        return result;
    }

    public static void main(String[] args) {
        String s =
                "00";
        System.out.println(new CountBinarySubstrings696().countBinarySubstrings(s));
    }
}
