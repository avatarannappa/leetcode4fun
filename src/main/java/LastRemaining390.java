/**
 * 390. 消除游戏
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/20
 */
public class LastRemaining390 {

    public int lastRemaining(int n) {
        // 1 2 3 4 5 6 7 8 9
        if (n == 1) {
            return 1;
        }
        return n % 2 == 0 ? 2 * (n / 2 + 1 - lastRemaining(n / 2)) : lastRemaining(n - 1);
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(new LastRemaining390().lastRemaining(n));
    }
}
