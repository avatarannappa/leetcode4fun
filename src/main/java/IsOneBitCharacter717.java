/**
 * 717. 1比特与2比特字符
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/17
 */
public class IsOneBitCharacter717 {

    private static int[] bits;

    public boolean isOneBitCharacter(int[] bits) {
        this.bits = bits;
        return recursion(0, bits.length - 1);
    }

    public boolean recursion(int start, int end) {
        int nowBit = bits[start];
        if (start == end) {
            return nowBit == 0;
        }
        boolean sign = false;
        if (nowBit == 0) {
            sign = recursion(start + 1, end);
        } else {
            if (start + 2 <= end) {
                sign = recursion(start + 2, end);
            }
        }
        return sign;
    }

    public static void main(String[] args) {
        int[] bits = {1, 1, 1, 0};
        System.out.println(new IsOneBitCharacter717().isOneBitCharacter(bits));
    }
}
