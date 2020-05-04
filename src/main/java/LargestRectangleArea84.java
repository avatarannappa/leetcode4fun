/**
 * 84. 柱状图中最大的矩形.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/4
 */
public class LargestRectangleArea84 {

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        if (heights == null || heights.length == 0) {
            return max;
        }
        int min = 0;
        for (int i = 0; i < heights.length; i++) {
            min = heights[i];
            for (int j = i; j < heights.length; j++) {
                int now = heights[j];
                if (now < min) {
                    min = now;
                }
                int temp = (j - i + 1) * min;
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleArea84().largestRectangleArea(heights));
    }
}
