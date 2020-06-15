import java.util.Arrays;

/**
 * 130.被围绕的区域
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/15
 */
public class Solve130 {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solve(char[][] board) {
        //遍历边上的O
        //这里可以只遍历四条边，但是好像影响不大。
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O') {
                    helper(board, i, j);
                }
            }
        }
        //把K改成O，其他改成X
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == 'K' ? 'O' : 'X';
            }
        }
    }

    void helper(char[][] board, int i, int j) {
        board[i][j] = 'K';
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 'O') {
                helper(board, x, y);
            }
        }
    }

    char[][] board;
    int[][] mask;
    int m;
    int n;

    public void solveOld(char[][] board) {
        // 正向思路，最后一个超时 bfs 回溯
        this.board = board;
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        mask = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (mask[i][j] == 0) {
                        edge(i, j);
                    }
                } else {
                    mask[i][j] = 99;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mask[i][j] == 2) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public int edge(int i, int j) {

        if (board[i][j] == 'X') {
            return -1;
        }
        if (mask[i][j] > 1) {
            return -1;
        }
        if (mask[i][j] == 1) {
            return 0;
        }
        if (mask[i][j] == -1) {
            return 1;
        }

        mask[i][j] = 1;
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
            mask[i][j] = -1;
            return 1;
        }
        // bfs
        int up = edge(i - 1, j);
        int left = edge(i, j - 1);
        int right = edge(i, j + 1);
        int down = edge(i + 1, j);
        if (up > 0 || left > 0 || right > 0 || down > 0) {
            mask[i][j] = -1;
            return 1;
        } else if (up == 0 || left == 0 || right == 0 || down == 0) {
            // backTracking
            mask[i][j] = 0;
            return -1;
        } else {
            // backTracking
            mask[i][j] = 2;
            return -1;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        //        char[][] board = {
        //                {'O','O','O','O','X','X'},
        //                {'O','O','O','O','O','O'},
        //                {'O','X','O','X','O','O'},
        //                {'O','X','O','O','X','O'},
        //                {'O','X','O','X','O','O'},
        //                {'O','X','O','O','O','O'}};
        //        char[][] board =
        //                {{'X', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O'}, {'X', 'O', 'O', 'X', 'X', 'X', 'O',
        //                'O', 'O', 'X'},
        //                        {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X'},
        //                        {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X'},
        //                        {'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O'},
        //                        {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O'},
        //                        {'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O'},
        //                        {'X', 'X', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'X'},
        //                        {'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O'},
        //                        {'X', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O'}};
        new Solve130().solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
        // \u000a System.out.println("hello");
    }
}
