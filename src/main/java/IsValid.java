import java.util.Stack;

/**
 * @author avatarannappa
 * @version 1.0, 2019/2/28
 */
public class IsValid {
    public static boolean isValid(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.equals("");
    }

    public static boolean toyIsValid(String s) {
        return stackIsValid(s);
    }

    public static boolean stackIsValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if ((c == '(') || (c == '[') || (c == '{')) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cPop = stack.pop();
                if (!pair(cPop, c)) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
/*
    public static boolean isValidRecursion(Integer index, String s, String preStr) {
        if (s.isEmpty() || index.equals(s.length() - 1)) {
            return true;
        }

        if (s.charAt(index) == ' ') {
            return isValidRecursion(index + 1, s.substring(1), preStr);
        } else if (preStr.isEmpty()) {
            return isValidRecursion(index + 1, s.substring(1), preStr + s.charAt(index));
        } else if (pair(s.charAt(index), preStr.charAt(preStr.length() - 1))) {
            return isValidRecursion();
        } else {
            return;
        }
    }*/

    public static boolean pair(Character charA, Character charB) {
        if ((charA == '{' && charB == '}') || charA == '[' && charB == ']' || charA == '(' && charB == ')') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(isValid(str));
    }
}
