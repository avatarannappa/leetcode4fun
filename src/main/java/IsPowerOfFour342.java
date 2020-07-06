/**
 * 342. 4的幂.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/6
 */
public class IsPowerOfFour342 {

    public boolean isPowerOfFour(int num) {
        return (num >= 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }

    public static void main(String[] args) {
        int num = 1024 * 1024;
        System.out.println(new IsPowerOfFour342().isPowerOfFour(num));
        System.out.println(Long.valueOf("10101010101010101010101010101010", 2));
        System.out.println(Long.valueOf("aaaaaaaa", 16));
    }
}
