/**
 * 1328. 破坏回文串.
 * medium
 *
 * @author avatarannappa
 * @version 2025/3/5
 */
public class BreakPalindrome1328 {

    public String breakPalindromeNew(String palindrome) {
        // 贪心
        // 题目保证了输入是回文串。所以不会有“abaa”这种修改一个字母到a，新字符串是回文串的情况
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }
        // 把第一个不等于 a 的字母改成 a
        // 只需找前一半，如果前一半没有不等于 a 的字母，那么后一半肯定也没有
        char[] s = palindrome.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            if (s[i] != 'a') {
                s[i] = 'a';
                return new String(s);
            }
        }
        // 除了回文中心，全是 a
        s[n - 1] = 'b';  // 最后一个字母改成 b
        return new String(s);
    }

    public String breakPalindrome(String palindrome) {
        // 贪心
        if (palindrome.length() <= 1) {
            return "";
        }
        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char t = chars[i];
            if (t != 'a') {
                chars[i] = 'a';
                if (!isPalindrome(chars)) {
                    return array2str(chars);
                }
                chars[i] = t;
            }
        }
        chars[chars.length - 1] = 'b';
        return array2str(chars);
    }

    public String array2str(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static boolean isPalindrome(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            if (s[l++] != s[r--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String palindrome = "abaa";
        // aaccba
        System.out.println(new BreakPalindrome1328().breakPalindromeNew(palindrome));
    }

}
