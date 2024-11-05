/**
 * 3222. 求出硬币游戏的赢家.
 * easy
 *
 * @author avatarannappa
 * @version 2024/11/5
 */
public class LosingPlayer3222 {

    public String losingPlayer(int x, int y) {
        int cnt = Math.min(x, y / 4);
        return cnt % 2 == 0 ? "Bob" : "Alice";
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 7;
        // alice
        System.out.println(new LosingPlayer3222().losingPlayer(x, y));
    }
}
