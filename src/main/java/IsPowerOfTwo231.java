/**
 * 231. 2的幂
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/30
 */
public class IsPowerOfTwo231 {

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        } else if (n == 1) {
            return true;
        }
        do {
            if (n % 2 == 1) {
                return false;
            }
            n = n / 2;
        } while (n / 2 > 1);
        return true;
    }

    public static void main(String[] args) {
        int n = 1024;
        System.out.println(new IsPowerOfTwo231().isPowerOfTwo(n));
    }
}
