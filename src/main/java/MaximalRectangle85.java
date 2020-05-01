import java.util.Stack;

/**
 * 85. 最大矩形
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/1
 */
public class MaximalRectangle85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null && matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            max = Math.max(max, leetcode84(dp));
        }
        return max;
    }

    public int leetcode84(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxarea;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(new MaximalRectangle85().maximalRectangle(matrix));
    }
}
