/**
 * 65. 有效数字.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/27
 */
public class IsNumber65 {

    public boolean isNumber(String s) {
        // TODO Deterministic Finite Automaton, 简写：DFA确定有穷自动机
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean isE = false;
        boolean isDot = false;
        boolean isNum = false;
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if ('e' == c) {
                if (isE || !isNum) {
                    return false;
                }
                isE = true;
                isNum = false;
            } else if ('.' == c) {
                if (isDot || isE) {
                    return false;
                }
                isDot = true;
            } else if ('-' == c || '+' == c) {
                if (i != 0 && arr[i - 1] != 'e') {
                    return false;
                }
            } else if (c >= '0' && c <= '9') {
                isNum = true;
            } else {
                return false;
            }
        }
        return isNum;
    }

    public static void main(String[] args) {
        String s = "53.5e93";
        System.out.println(new IsNumber65().isNumber(s));
    }

}
