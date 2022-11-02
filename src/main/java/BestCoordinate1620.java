import java.util.Arrays;

/**
 * 1620. 网络信号最好的坐标
 * medium
 *
 * @author avatarannappa
 * @date 2022/11/2
 */
public class BestCoordinate1620 {

    public int[] bestCoordinate(int[][] towers, int radius) {
        int x = 0;
        int y = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 110; i++) {
            for (int j = 0; j < 110; j++) {
                int quality = 0;
                for (int[] tower : towers) {
                    double distance = getDistance(i, j, tower);
                    if (distance <= radius) {
                        quality += (int) Math.floor(tower[2] / (1 + distance));
                    }
                    if (quality > max) {
                        x = i;
                        y = j;
                        max = quality;
                    }
                }
            }
        }

        return new int[]{x, y};
    }

    private double getDistance(int x, int y, int[] tower) {
        int i = tower[0];
        int j = tower[1];

        return Math.sqrt(Math.pow(x - i, 2) + Math.pow(y - j, 2));
    }

    public static void main(String[] args) {
        // 输入：towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
        // 输出：[2,1]
        int[][] towers = {{1, 2, 5}, {2, 1, 7}, {3, 1, 9}};
        int radius = 2;
        System.out.println(Arrays.toString(new BestCoordinate1620().bestCoordinate(towers, 2)));
    }
}
