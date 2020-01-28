/**
 * 344. 反转字符串
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/28
 */
public class ReverseString344 {

    public void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }
        int half = s.length / 2;
        int end = s.length - 1;
        for (int i = 0; i < half; i++) {
            int r = end - i;
            char temp = s[r];
            s[r] = s[i];
            s[i] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'A', ' ', 'm', 'a', 'n', ',', ' ', 'a', ' ', 'p', 'l', 'a', 'n', ',', ' ', 'a', ' ', 'c', 'a', 'n',
                'a', 'l', ':', ' ', 'P', 'a', 'n', 'a', 'm', 'a'};
        System.out.println(s.length);
        new ReverseString344().reverseString(s);
        System.out.println(s);
    }
}
