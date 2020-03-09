import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/9
 */
public class OrangesRotting994 {

    int m = 0;
    int n = 0;
    Queue<int[]> queue = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        offer(grid);
        if (queue.isEmpty()) {
            int sign = freshOrRot(grid);
            if (sign == 0) {
                return 0;
            } else if (sign == 1) {
                return -1;
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                int[] s = queue.poll();
                rot(s[0], s[1], grid);
                grid[s[0]][s[1]] = 0;
            }
            int sign = freshOrRot(grid);
            if (sign == 0) {
                return count;
            } else if (sign == 2) {
                return count + 1;
            } else if (sign == 1) {
                return -1;
            }

            offer(grid);
            count++;
        }

        return count;
    }

    public void rot(int i, int j, int[][] grid) {
        if (i != 0) {
            grid[i - 1][j] = grid[i - 1][j] == 0 ? 0 : 2;
        }
        if (j != 0) {
            grid[i][j - 1] = grid[i][j - 1] == 0 ? 0 : 2;
        }
        if (i != m - 1) {
            grid[i + 1][j] = grid[i + 1][j] == 0 ? 0 : 2;
        }
        if (j != n - 1) {
            grid[i][j + 1] = grid[i][j + 1] == 0 ? 0 : 2;
        }
    }

    public void offer(int[][] grid) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    int[] s = new int[2];
                    s[0] = i;
                    s[1] = j;
                    queue.offer(s);
                }
            }
        }
    }

    public int freshOrRot(int[][] grid) {
        int rot = 0;
        int fresh = 0;
        int zero = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    zero++;
                } else if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rot++;
                }
            }
        }
        if (zero == m * n) {
            return 0;
        } else if (zero + fresh == m * n) {
            return 1;
        } else if (zero + rot == m * n) {
            return 2;
        }
        return 4;
    }

    public void print(int[][] t) {
        System.out.println("-----------start-------------");
        for (int i = 0; i < t.length; i++) {
            System.out.println(Arrays.toString(t[i]));
        }
        System.out.println("----------- end  -------------");
    }

    public boolean isolation(int i, int j, int[][] grid) {
        boolean sign = true;
        sign &= (i == 0) || (grid[i - 1][j] == 0);
        sign &= (j == 0) || (grid[i][j - 1] == 0);
        sign &= (i == m - 1) || (grid[i + 1][j] == 0);
        sign &= (j == n - 1) || (grid[i][j + 1] == 0);
        return sign;
    }

    public static void main(String[] args) {
        // int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(new OrangesRotting994().orangesRotting(grid));
    }
}
