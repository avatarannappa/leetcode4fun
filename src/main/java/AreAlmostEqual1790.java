/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * easy
 *
 * @author avatarannappa
 * @date 2022/10/11
 */
public class AreAlmostEqual1790 {

    public boolean areAlmostEqual(String s1, String s2) {
        char a1 = ' ';
        char a2 = ' ';
        char b1 = ' ';
        char b2 = ' ';
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (a1 == ' ') {
                    a1 = s1.charAt(i);
                    a2 = s2.charAt(i);
                } else {
                    b1 = s1.charAt(i);
                    b2 = s2.charAt(i);
                }
            }
            if (count > 2) {
                return false;
            }
        }
        return count == 0 || (count == 2 && a1 == b2 && b1 == a2);
    }

    public static void main(String[] args) {
        String s1 = "bank";
        String s2 = "kanb";
        System.out.println(new AreAlmostEqual1790().areAlmostEqual(s1, s2));
    }
}
