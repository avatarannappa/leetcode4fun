/**
 * 5. 最长回文子串.
 * medium
 *
 * @author avatarannappa on 2017/6/13.
 */
public class LongestPalindrome5 {

    public static void main(String[] args) {
        String s = "cbbd";
        LongestPalindrome5 lp = new LongestPalindrome5();
        String lpStr = lp.longestPalindromeNew(s);
        System.out.println(lpStr);
    }

    public String longestPalindromeNew(String s) {
        // 中心扩展
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] arr = s.toCharArray();
        int n = arr.length;
        int max = 0;
        String result = "";
        for (int i = 0; i < n; i++) {
            int a = expand(arr, i, i);
            int b = expand(arr, i, i + 1);
            if (b * 2 > max && b >= a) {
                result = s.substring(i - b + 1, i + b + 1);
                max = b * 2;
            } else if ((a - 1) * 2 + 1 > max) {
                result = s.substring(i - a + 1, i + a);
                max = (a - 1) * 2 + 1;
            }
        }
        return result;
    }

    public int expand(char[] arr, int i, int j) {
        int a = 0;
        while (i >= 0 && j < arr.length) {
            if (arr[i] != arr[j]) {
                break;
            }
            i--;
            j++;
            a++;
        }
        return a;
    }

    public String longestPalindrome(String s) {
        String result = "";
        if (s == null || s.length() == 0) {
            return result;
        }
        char[] cs = s.toCharArray();
        int maxLen = 1;
        int posMid = 1;
        int start = 0;
        int end = 0;
        for (int i = 0; i < cs.length; i++) {
            int l1 = maxMid(cs, i);
            int l2 = maxMir(cs, i);
            int lm = l1 >= l2 ? l1 : l2;
            if (lm > maxLen) {
                if (lm == l1) {
                    start = i - lm / 2;
                    end = i + lm / 2;
                } else {
                    start = i - (lm - 2) / 2;
                    end = i + lm / 2;
                }
                maxLen = lm;
            }
        }

        result = s.substring(start, end + 1);
        return result;
    }

    public int maxMid(char[] cs, int i) {
        int len = 0;
        for (int j = 1; j <= i; j++) {
            if (i - j >= 0 && i + j < cs.length && cs[i - j] == cs[i + j]) {
                len = j * 2 + 1;
            } else {
                break;
            }
        }
        return len;
    }

    public int maxMir(char[] cs, int i) {
        int len = 0;
        for (int j = 0; j <= i; j++) {
            if (i - j >= 0 && i + 1 + j < cs.length && cs[i - j] == cs[i + 1 + j]) {
                len = 2 * j + 2;
            } else {
                break;
            }
        }
        return len;
    }

}
