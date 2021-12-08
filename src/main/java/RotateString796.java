/**
 * 796. 旋转字符串.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/8
 */
public class RotateString796 {

    public boolean rotateString(String s, String goal) {
        if (s == null || goal == null || s.length() != goal.length()) {
            return false;
        }
        char head = goal.charAt(0);
        for (int i = s.indexOf(head); i < s.length(); i = s.indexOf(head, i + 1)) {
            if (i < 0) {
                break;
            }
            String ss = s.substring(i, s.length()) + s.substring(0, i);
            if (ss.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public boolean rotateStringNew(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "abced";
        System.out.println(new RotateString796().rotateString(s, goal));
    }
}
