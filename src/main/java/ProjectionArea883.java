import java.util.stream.IntStream;

/**
 * 883. 三维形体投影面积.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/24
 */
public class ProjectionArea883 {
    public int projectionArea(int[][] grid) {
        int a = 0;
        int[] b = new int[grid.length];
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                a++;
                b[j] = Math.max(b[j], grid[i][j]);
                c = Math.max(c, grid[i][j]);
            }
            a += c;
            c = 0;
        }
        a += IntStream.of(b).sum();
        return a;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 2 }, { 3, 4 } };
        // 17
        System.out.println(new ProjectionArea883().projectionArea(grid));
    }
}
