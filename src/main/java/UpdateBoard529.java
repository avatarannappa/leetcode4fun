import java.util.Arrays;

/**
 * 529. 扫雷游戏.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/30
 */
public class UpdateBoard529 {

    int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    int y;
    int x;

    public char[][] updateBoard(char[][] board, int[] click) {
        y = board.length;
        x = board[0].length;
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        } else if (board[i][j] == 'E') {
            recursion(board, i, j);
        }
        return board;
    }

    public void recursion(char[][] board, int i, int j) {
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int ii = i + dx[k];
            int jj = j + dy[k];
            if (ii >= 0 && ii < y && jj >= 0 && jj < x && board[ii][jj] == 'M') {
                count++;
            }
        }
        if (count == 0) {
            board[i][j] = 'B';
            for (int k = 0; k < 8; k++) {
                int ii = i + dx[k];
                int jj = j + dy[k];
                if (ii >= 0 && ii < y && jj >= 0 && jj < x && board[ii][jj] == 'E') {
                    recursion(board, ii, jj);
                }
            }
        } else {
            char c = (char) ('0' + count);
            board[i][j] = c;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click0 = {3, 0};
        char[][] result = new UpdateBoard529().updateBoard(board, click0);
        for (char[] chars : result) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println("---------------------");
        int[] click1 = {1, 2};
        result = new UpdateBoard529().updateBoard(board, click1);
        for (char[] chars : result) {
            System.out.println(Arrays.toString(chars));
        }

    }
}
