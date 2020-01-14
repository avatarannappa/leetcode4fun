/**
 * 289. 生命游戏
 *
 * @author avatarannappa
 * @version 1.0, 2019/10/30
 */
public class GameOfLife289 {
    public void gameOfLife(int[][] board) {

        int yTop = 0;
        int yBottom = board.length - 1;
        int xLeft = 0;
        int xRight = board[0].length - 1;
        int[][] temp = new int[yBottom + 1][xRight + 1];

        for (int i = 0; i < yBottom + 1; i++) {
            for (int j = 0; j < xRight + 1; j++) {
                temp[i][j] = board[i][j];
            }
        }

        int[][] mask = new int[3][3];
        for (int i = 0; i < yBottom + 1; i++) {
            for (int j = 0; j < xRight + 1; j++) {
                mask[0][0] = 0;
                mask[1][0] = 0;
                mask[2][0] = 0;
                mask[0][1] = 0;
                mask[1][1] = temp[i][j];
                mask[2][1] = 0;
                mask[0][2] = 0;
                mask[1][2] = 0;
                mask[2][2] = 0;

                if (i != yTop) {
                    mask[0][1] = temp[i - 1][j];
                }
                if (i != yBottom) {
                    mask[2][1] = temp[i + 1][j];
                }
                if (j != xLeft) {
                    mask[1][0] = temp[i][j - 1];
                }
                if (j != xRight) {
                    mask[1][2] = temp[i][j + 1];
                }

                if (j != xLeft && i != yTop) {
                    mask[0][0] = temp[i - 1][j - 1];
                }
                if (j != xRight && i != yTop) {
                    mask[0][2] = temp[i - 1][j + 1];
                }
                if (j != xRight && i != yBottom) {
                    mask[2][2] = temp[i + 1][j + 1];
                }
                if (j != xLeft && i != yBottom) {
                    mask[2][0] = temp[i + 1][j - 1];
                }
                board[i][j] = mask(mask);
            }
        }

    }

    public int mask(int[][] mask) {
        int result = 0;
        int origin = mask[1][1];
        for (int i = 0; i < mask.length; i++) {
            for (int j = 0; j < mask[0].length; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                result += mask[i][j];
            }
        }
        if (result < 2) {
            return 0;
        } else if (result == 2) {
            return origin;
        } else if (result == 3) {
            return 1;
        } else {
            return 0;
        }
    }

    public void gameOfLife1(int[][] board) {
        /**
         利用一个 two bits 的状态机来记录细胞状态, 第一位表示
         下一状态, 第二位表示当前状态:
         00: dead (next state) <- dead (current state)
         01: dead (next state) <- live (current state)
         10: live (next state) <- dead (current state)
         11: live (next state) <- live (current state)
         初始情况对应就是 00 和 01 (默认下一状态是 dead state)
         统计每个位置周围的 live 细胞数决定高位置 1 (live)还是
         0 (dead), 最后右移一位即为最终状态, 注意不需要考虑 01
         以及 00 的情况, 因为已经默认下一状态为 dead.
         **/
        if (board.length < 1) {
            return;
        }
        // 更新矩阵
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int lives = countLives(board, i, j);
                if ((board[i][j] & 1) == 1) {
                    // live -> live
                    if (lives >= 2 && lives <= 3) {
                        board[i][j] = 3;
                    }
                } else {
                    // dead -> live
                    if (lives == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        // 重置矩阵
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] >>= 1;
            }
        }
    }

    private int countLives(int[][] b, int i, int j) {
        int count = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x > b.length - 1 || y < 0 || y > b[0].length - 1) {
                continue;
            }
            count += (b[x][y] & 1);
        }
        return count;
    }

    public static void main(String[] args) {
        GameOfLife289 gameOfLife289 = new GameOfLife289();
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife289.gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(',');
            }
            System.out.println("");
        }
    }
}
