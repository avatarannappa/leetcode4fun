/**
 * 125. 验证回文串
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/14
 */
public class IsPalindrome125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        if (s == null || s.length() <= 1) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(new IsPalindrome125().isPalindrome(s));
    }
}
