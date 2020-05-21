import java.util.Arrays;

/**
 * 59. 螺旋矩阵II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/21
 */
public class GenerateMatrix59 {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int x = 0;
        int y = 0;
        int sign = 0; // 0右边 1下 2左 3上
        for (int i = 0; i < n * n; i++) {
            result[y][x] = i + 1;
            if (sign == 0) {
                x++;
                if (x == n || result[y][x] != 0) {
                    sign = 1;
                    x--;
                    y++;
                }
            } else if (sign == 1) {
                y++;
                if (y == n || result[y][x] != 0) {
                    sign = 2;
                    y--;
                    x--;
                }
            } else if (sign == 2) {
                x--;
                if (x == -1 || result[y][x] != 0) {
                    sign = 3;
                    x++;
                    y--;
                }
            } else {
                // sign = 3;
                y--;
                if (y == -1 || result[y][x] != 0) {
                    sign = 0;
                    y++;
                    x++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] result = new GenerateMatrix59().generateMatrix(n);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
