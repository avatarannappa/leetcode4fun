
/**
 * 263. 丑数.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/3
 */
public class IsUgly263 {

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num %2 ==0) {
            num = num / 2;
        }
        while (num %3 ==0) {
            num = num / 3;
        }
        while (num %5 ==0) {
            num = num / 5;
        }
        if (num == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 6;
        System.out.println(new IsUgly263().isUgly(num));
    }
}
