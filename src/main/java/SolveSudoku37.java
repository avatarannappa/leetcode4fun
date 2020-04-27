import java.util.Arrays;

/**
 * 37. 解数独.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/27
 */
public class SolveSudoku37 {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        backTracking(board, 0, 0);
    }

    public boolean backTracking(char[][] board, int x, int y) {
        if (y == 9) {
            return true;
        }
        if (x == 9) {
            return backTracking(board, 0, y + 1);
        }
        if (board[y][x] != '.') {
            return backTracking(board, x + 1, y);
        }
        for (char i = '1'; i <= '9'; i++) {
            if (!check(board, x, y, i)) {
                continue;
            }
            board[y][x] = i;
           if (backTracking(board, x + 1, y))
               return true;
            board[y][x] = '.';
        }
        return false;
    }

    public boolean check(char[][] board, int x, int y, char c) {
        // 是否和行、列、方格内重复
        for (int i = 0; i < 9; i++) {
            // line
            if (board[y][i] == c) {
                return false;
            }
            // column
            if (board[i][x] == c) {
                return false;
            }
            // grid
            int gy = (y / 3) * 3;
            int gx = (x / 3) * 3;
            if (board[gy + i / 3][gx + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new SolveSudoku37().solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
