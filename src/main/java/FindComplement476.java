/**
 * 476. 数字的补数.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/29
 */
public class FindComplement476 {
    public int findComplement(int num) {
        int mask = 1;
        int temp = num;
        while (num > 0) {
            num = num >> 1;
            mask = mask << 1;
        }
        return (mask - 1) ^ temp;
    }
}
