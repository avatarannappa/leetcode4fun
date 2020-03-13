/**
 * 367. 有效的完全平方数
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/13
 */
public class IsPerfectSquare367 {

    public boolean isPerfectSquare(int num) {
        if (num == 0) {
            return false;
        }
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0 ? true : false;
    }

    public boolean isPerfectSquareNiu(int num) {
        // 牛顿迭代法
        if (num < 2) {
            return true;
        }
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }

    public static void main(String[] args) {
        System.out.println(new IsPerfectSquare367().isPerfectSquare(16));
    }
}
