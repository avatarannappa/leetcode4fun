import java.util.Arrays;

/**
 * 389. 找不同.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/25
 */
public class FindTheDifference389 {

    public char findTheDifference(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i]) {
                return tArray[i];
            }
        }
        return tArray[t.length() - 1];
    }

}
