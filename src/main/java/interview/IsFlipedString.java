package interview;

/**
 * 面试题 01.09. 字符串轮转
 * easy
 *
 * @author avatarannappa
 * @date 2022/9/29
 */
public class IsFlipedString {

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                if (s1.substring(i).equals(s2.substring(0, n - i)) && s1.substring(0, i).equals(s2.substring(n - i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 输入：s1 = "waterbottle", s2 = "erbottlewat"
        // 输出：True
        String s1 = "";
        String s2 = "";
        System.out.println(new IsFlipedString().isFlipedString(s1, s2));
    }
}
