/**
 * 3的幂
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/31
 */
public class IsPowerOfThree326 {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new IsPowerOfThree326().isPowerOfThree(3));
    }
}
