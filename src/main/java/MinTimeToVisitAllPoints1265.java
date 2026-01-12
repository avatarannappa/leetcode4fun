/**
 * 1265. 访问所有点的最小时间.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2026/1/12
 */
public class MinTimeToVisitAllPoints1265 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;

        for (int i = 1; i < points.length; i++) {
            int[] start = points[i - 1];
            int[] end = points[i];
            int x = Math.abs(start[0] - end[0]);
            int y = Math.abs(start[1] - end[1]);
            res += Math.max(x, y);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
        // 7
        System.out.println(new MinTimeToVisitAllPoints1265().minTimeToVisitAllPoints(points));
    }
}
