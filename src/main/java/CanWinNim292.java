/**
 * 292. Nim 游戏.
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/15
 */
public class CanWinNim292 {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        System.out.println(new CanWinNim292().canWinNim(4));
    }
}
