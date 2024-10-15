/**
 * 3200. 三角形的最大高度.
 * easy
 *
 * @author avatarannappa
 * @version 2024/10/15
 */
public class MaxHeightOfTriangle3200 {

    public int maxHeightOfTriangle(int red, int blue) {
        // 数学
        return Math.max(count(red, blue), count(blue, red));
    }

    private int count(int red, int blue) {
        int odd = (int) Math.floor(Math.sqrt(red));
        int even = (int) Math.floor(Math.sqrt(blue + 0.25) - 0.5);
        return odd > even ? even * 2 + 1 : odd * 2;
    }

    public static void main(String[] args) {
        int red = 2;
        int blue = 1;
        // 3
        System.out.println(new MaxHeightOfTriangle3200().maxHeightOfTriangle(red, blue));
    }
}
