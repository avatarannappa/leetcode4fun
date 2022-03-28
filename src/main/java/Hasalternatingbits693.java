/**
 * 693. 交替位二进制数.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/3/28
 */
public class Hasalternatingbits693 {

    public boolean hasAlternatingBits(int n) {
        String str = Integer.toBinaryString(n);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        // true
        System.out.println(new Hasalternatingbits693().hasAlternatingBits(n));
    }

}
