import java.util.Arrays;

/**
 * 733. 图像渲染.
 *
 * @author avatarannappa
 * @version 1.0, 2020/08/16
 */
public class FloodFill733 {

    int[][] result;
    int newColor;
    int oldColor;
    int r;
    int c;
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        r = image.length;
        c = image[0].length;
        result = image;
        this.newColor = newColor;
        this.oldColor = result[sr][sc];
        if (newColor != oldColor) {
            recursion(sr, sc);
        }
        return result;
    }

    public void recursion(int sr, int sc) {
        result[sr][sc] = newColor;
        for (int i = 0; i < 4; i++) {
            int srNew = sr + dr[i];
            int scNew = sc + dc[i];
            if (srNew >= 0 && srNew < r && scNew >= 0 && scNew < c && result[srNew][scNew] == oldColor) {
                recursion(srNew, scNew);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] result = new FloodFill733().floodFill(image, sr, sc, newColor);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
