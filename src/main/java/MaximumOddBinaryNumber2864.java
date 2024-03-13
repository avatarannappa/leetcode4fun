/**
 * 2864. 最大二进制奇数
 * easy
 *
 * @author avatarannappa
 * @date 2024/3/13
 */
public class MaximumOddBinaryNumber2864 {

    public String maximumOddBinaryNumber(String s) {
        String res = "";
        boolean first = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                if (first) {
                    first = false;
                    continue;
                }
                res = '1' + res;
            } else {
                res = res + '0';
            }
        }

        return res + "1";
    }
}
