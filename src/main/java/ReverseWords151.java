/**
 * 151. 翻转字符串里的单词.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/12
 */
public class ReverseWords151 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        if (s.length() == 0) {
            return s;
        }
        String result = "";
        String[] array = s.split(" ");
        String pre = null;
        for (int i = 0; i < array.length; i++) {
            String now = array[i];
            if (!"".equals(now)) {
                if (pre != null && !pre.equals("")) {
                    now += " ";
                }
                result = now + result;
                pre = now;
            } else {
                if (!pre.equals(now)) {
                    result = " " + result;
                }
                pre = now;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = " a good   example ";
        System.out.println(new ReverseWords151().reverseWords(s));
    }
}
