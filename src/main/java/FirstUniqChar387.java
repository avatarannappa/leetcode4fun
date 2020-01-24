import java.util.Arrays;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/25
 */
public class FirstUniqChar387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        } else if (s.length() == 1) {
            return 0;
        }
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (array[index] > 0) {
                array[index] = -1;
            } else if (array[index] == -1) {
                continue;
            } else {
                array[index] = i + 1;
            }
        }
        int position = -1;
        for (int i = 0; i < array.length; i++) {
            int tempP = array[i];
            if (position == -1) {
                if (tempP > 0) {
                    position = tempP;
                }
            } else {
                if (tempP > 0 && tempP < position) {
                    position = tempP;
                }
            }
        }
        if (position == -1) {
            return -1;
        }
        return position - 1;
    }

    public static void main(String[] args) {
        String s = "cc";
        System.out.println(new FirstUniqChar387().firstUniqChar(s));
    }
}
