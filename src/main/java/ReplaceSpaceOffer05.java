/**
 * 剑指 Offer 05. 替换空格
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/18
 */
public class ReplaceSpaceOffer05 {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(new ReplaceSpaceOffer05().replaceSpace(s));
    }
}
