/**
 * 79. 单词搜索
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/7
 */
public class Exist79 {

    // 偏移向量右，下，左，上
    private int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private char[][] board;
    private int n;
    private int m;
    private char[] w;
    private boolean[][] visit;

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }
        this.board = board;
        n = board.length;
        m = board[0].length;
        w = word.toCharArray();
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, 0) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int start) {
        if (board[i][j] == w[start]) {
            if (start == w.length - 1) {
                // word匹配结束
                return true;
            } else {
                visit[i][j] = true;
                for (int t = 0; t < 4; t++) {
                    int newI = i + direction[t][0];
                    int newJ = j + direction[t][1];
                    if (in(newI, newJ) && !visit[newI][newJ]) {
                        if (dfs(newI, newJ, start + 1)) {
                            return true;
                        }
                    }
                }
                visit[i][j] = false;
            }
        }
        return false;
    }

    public boolean in(int i, int j) {
        // 点在矩阵内
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new Exist79().exist(board, word));
    }
}
