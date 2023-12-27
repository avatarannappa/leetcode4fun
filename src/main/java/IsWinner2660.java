/**
 * 2660. 保龄球游戏的获胜者
 * easy
 *
 * @author avatarannappa
 * @date 2023/12/27
 */
public class IsWinner2660 {

    public int isWinner(int[] player1, int[] player2) {
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < player1.length; i++) {
            if (i == 0) {
                s1 += player1[i];
                s2 += player2[i];
            } else if (i == 1) {
                if (player1[i - 1] == 10) {
                    s1 += player1[i] * 2;
                } else {
                    s1 += player1[i];
                }

                if (player2[i - 1] == 10) {
                    s2 += player2[i] * 2;
                } else {
                    s2 += player2[i];
                }
            } else {
                if (player1[i - 1] == 10 || player1[i - 2] == 10) {
                    s1 += player1[i] * 2;
                } else {
                    s1 += player1[i];
                }

                if (player2[i - 1] == 10 || player2[i - 2] == 10) {
                    s2 += player2[i] * 2;
                } else {
                    s2 += player2[i];
                }
            }
        }
        return s1 >= s2 ? (s1 > s2 ? 1 : 0) : 2;
    }
}
