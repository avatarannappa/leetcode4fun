/**
 * 925. 长按键入.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/26
 */
public class IsLongPressedName925 {

    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null || name.length() > typed.length()) {
            return false;
        }

        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        int i = 1;
        int j = 1;
        for (; i < name.length(); i++) {
            char nameChar = name.charAt(i);
            while (j < typed.length() && name.charAt(i - 1) == typed.charAt(j) && typed.charAt(j) != nameChar) {
                j++;
            }
            if (j >= typed.length()) {
                return false;
            }
            if (nameChar != typed.charAt(j)) {
                // String name = "alex";
                // String typed = "alexxlr";
                return false;
            }
            j++;

        }
        if (j < typed.length()) {
            // String name = "alex";
            // String typed = "alexxr";
            int end = typed.charAt(j - 1);
            while (j < typed.length()) {
                if (typed.charAt(j) != end) {
                    return false;
                }
                j++;
            }
        }

        return i == name.length();
    }

    public static void main(String[] args) {
        String name = "alex";
        String typed = "alexxr";
        System.out.println(new IsLongPressedName925().isLongPressedName(name, typed));
    }

}
