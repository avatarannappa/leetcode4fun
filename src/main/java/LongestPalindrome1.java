/**
 * Created by avatarannappa on 2017/6/13.
 */
public class LongestPalindrome1 {

    public static void main(String[] args) {
        String s = "bb";
        LongestPalindrome1 lp = new LongestPalindrome1();
        String lpStr = lp.longestPalindrome(s);
        System.out.println(lpStr);
    }

    public String longestPalindrome(String s) {
        String result = "";
        if (s == null || s.length()==0) {
            return result;
        }
        char[] cs = s.toCharArray();
        int maxLen = 1;
        int posMid = 1;
        int start = 0;
        int end = 0;
        for (int i = 0; i < cs.length ; i++) {
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
