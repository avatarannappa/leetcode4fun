/**
 * 214. 最短回文串
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/18
 */
public class SortestPalindrome214 {

    public String shortestPalindrome(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        String reverseS = sb.toString();
        for (int i = len; i >= 0; i--) {
            if (s.substring(0, i).equals(reverseS.substring(len - i, len))) {
                return reverseS.substring(0, len - i) + s;
            }
        }
        return "";
    }

    public String shortestPalindromeOld(String s) {
        // O(n ^ 2)
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        String reverseS = sb.toString();
        if (s.equals(reverseS)) {
            return s;
        }
        for (int i = len - 1; i >= 0; i--) {
            if (s.substring(0, i).equals(reverseS.substring(len - i, len))) {
                return reverseS.substring(0, len - i) + s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(new SortestPalindrome214().shortestPalindrome(s));
    }

}
