/**
 * 999. 可以被一步捕获的棋子数.
 * easy
 *
 * @author avatarannappa
 * @version 2024/12/6
 */
public class NumRookCaptures999 {

    public int numRookCaptures(char[][] board) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        int res = 0;

        for (int i = x + 1; i < 8; i++) {
            if (board[i][y] == 'B') {
                break;
            } else if (board[i][y] == 'p') {
                res++;
                break;
            }
        }

        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == 'B') {
                break;
            } else if (board[i][y] == 'p') {
                res++;
                break;
            }
        }

        for (int i = y + 1; i < 8; i++) {
            if (board[x][i] == 'B') {
                break;
            } else if (board[x][i] == 'p') {
                res++;
                break;
            }
        }

        for (int i = y - 1; i >= 0; i--) {
            if (board[x][i] == 'B') {
                break;
            } else if (board[x][i] == 'p') {
                res++;
                break;
            }
        }

        return res;
    }

}
