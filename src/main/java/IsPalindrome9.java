/**
 * 9. 回文数
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/23
 */
public class IsPalindrome9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        int revert = 0;
        int bound = 0;
        String xStr = String.valueOf(x);
        if (xStr.length() % 2 == 0) {
            // 偶数
            bound = xStr.length() / 2;
            for (int i = 0; i < bound; i++) {
                revert = revert * 10 + x % 10;
                x = x / 10;
            }
        } else {
            // 奇数
            bound = (xStr.length() - 1) / 2;
            for (int i = 0; i < bound; i++) {
                revert = revert * 10 + x % 10;
                x = x / 10;
            }
            x = x / 10;
        }
        return x == revert;
    }

    public static void main(String[] args) {
        IsPalindrome9 o = new IsPalindrome9();
        System.out.println(o.isPalindrome(88888));
    }
}
