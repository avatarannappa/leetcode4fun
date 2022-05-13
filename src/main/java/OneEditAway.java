/**
 * 面试题 01.05. 一次编辑.
 * meidum
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/5/13
 */
public class OneEditAway {

    public boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            int diff = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    diff++;
                }
            }
            return diff <= 1;
        } else if (first.length() - 1 == second.length()) {
            for (int i = 0; i < first.length(); i++) {
                if (i == first.length() - 1) {
                    return true;
                }
                if (first.charAt(i) != second.charAt(i)) {
                    return first.substring(i + 1).equals(second.substring(i));
                }
            }
            return true;
        } else if (first.length() + 1 == second.length()) {
            return oneEditAway(second, first);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        OneEditAway oneEditAway = new OneEditAway();
        System.out.println(oneEditAway.oneEditAway("", "a"));
    }
}
