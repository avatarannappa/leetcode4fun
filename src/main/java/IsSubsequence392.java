/**
 * 392. 判断子序列.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/16
 */
public class IsSubsequence392 {

    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int j = 0;
        for (int i = 0; i < tArray.length; i++) {
            if (sArray[j] == tArray[i]) {
                if (j == sArray.length - 1) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

}
