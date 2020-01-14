/**
 * 14. 最长公共前缀
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/23
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Character temp = null;
        int index = 0;
        boolean sign = true;
        while (true) {
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                if (index >= str.length()) {
                    sign = false;
                    break;
                }
                if (temp == null) {
                    temp = str.charAt(index);
                } else {
                    if (!temp.equals(str.charAt(index))) {
                        sign = false;
                        break;
                    }
                }
            }
            if (!sign) {
                break;
            } else {
                index++;
                if (temp != null) {
                    sb.append(temp);
                }
                temp = null;
            }

        }
        return sb.toString();
    }
}
