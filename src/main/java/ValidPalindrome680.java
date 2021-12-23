/**
 * 680. 验证回文字符串II.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/23
 */
public class ValidPalindrome680 {

    public boolean validPalindrome(String s) {

        return validPalindrome(s, true);
    }

    public boolean validPalindrome(String s, boolean first) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (l == r) {
                return true;
            }
            if (s.charAt(l) != s.charAt(r)) {
                if (first) {
                    first = false;
                    if (r - l == 1) {
                        return true;
                    } else {
                        boolean sign = false;
                        if (s.charAt(l + 1) == s.charAt(r)) {
                            sign = validPalindrome(s.substring(l + 1, r + 1), false);
                        }
                        if (sign) {
                            return true;
                        }
                        if (s.charAt(l) == s.charAt(r - 1)) {
                            sign = validPalindrome(s.substring(l, r), false);
                        }
                        if (sign) {
                            return true;
                        }
                        return false;
                    }
                } else {
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(new ValidPalindrome680().validPalindrome(s));
    }
}
