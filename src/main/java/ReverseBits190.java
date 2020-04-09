/**
 * 190. 颠倒二进制位.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/9
 */
public class ReverseBits190 {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n & 1;
            result = result | (temp << (31 - i));
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(new ReverseBits190().reverseBits(n));
    }
}
