/**
 * 97. 交错字符串.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/2
 */
public class IsInterleave97 {

    String s1;
    String s2;
    String s3;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        return backTracking(0, 0, 0);
    }

    public boolean backTracking(int i1, int i2, int i3) {
        if (i1 + i2 == s3.length()) {
            return true;
        }
        boolean sign = false;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            sign = backTracking(i1 + 1, i2, i3 + 1);
        }
        if (sign) {
            return true;
        }
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            sign = backTracking(i1, i2 + 1, i3 + 1);
        }
        return sign;
    }

    public static void main(String[] args) {
        // String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        String s1 = "aabc", s2 = "abad", s3 = "aabcabad";
        System.out.println(new IsInterleave97().isInterleave(s1, s2, s3));
    }

}
