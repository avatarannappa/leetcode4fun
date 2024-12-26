/**
 * @author avatarannappa
 * @version 2024/12/26
 */
public class IsSubstringPresent3083 {

    public boolean isSubstringPresent(String s) {
        // 模拟
        String reverse = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length() - 1; i++) {
            if (reverse.contains(s.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(new IsSubstringPresent3083().isSubstringPresent(s));
    }
}
