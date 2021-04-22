/**
 * 709. 转换成小写字母
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/22
 */
public class ToLowerCase709 {

    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int gap = 'A' - 'a';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c - gap);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "LOVELy";
        System.out.println(new ToLowerCase709().toLowerCase(str));
    }
}
