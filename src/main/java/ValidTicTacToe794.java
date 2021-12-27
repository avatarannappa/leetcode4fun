/**
 * 794. 有效的井字游戏.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/27
 */
public class ValidTicTacToe794 {
    
    public boolean validTicTacToe(String[] board) {
        // x先走
        int xCount = 0;
        int oCount = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ('O' == board[i].charAt(j)) {
                    oCount++;
                } else if ('X' == board[i].charAt(j)) {
                    xCount++;
                }
            }
        }
        if (oCount != xCount && oCount != xCount - 1) {
            return false;
        }
        if (win(board, 'X') && oCount != xCount - 1) {
            return false;
        }
        if (win(board, 'O') && oCount != xCount) {
            return false;
        }
        return true;
    }

    public boolean win(String[] board, char p) {
        for (int i = 0; i < 3; ++i) {
            if (p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i)) {
                return true;
            }
            if (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2)) {
                return true;
            }
        }
        if (p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2)) {
            return true;
        }
        if (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] board = {"XOX"," X ","   "};
        System.out.println(new ValidTicTacToe794().validTicTacToe(board));
    }
}
