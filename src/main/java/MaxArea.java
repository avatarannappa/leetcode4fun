import java.util.Arrays;

/**
 * 11.盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)
 * 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * @author avatarannappa
 * @version 1.0, 2019/6/11
 */
public class MaxArea {

    public static void main(String[] args) {
        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        int[] height = {2, 100, 1, 1, 1};
        System.out.println(maxArea2(height));
    }

    public static int maxArea(int[] height) {
        // 超出时间限制
        int[] matrix = new int[height.length * height.length];
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                matrix[i * j + i] = i == j ? 0 : Math.min(height[i], height[j]) * Math.abs(i - j);
            }
        }
        Arrays.sort(matrix);
        return matrix[matrix.length - 1];
    }

    public static int maxArea1(int[] height) {
        // 一半，且不用记录所有桶大小
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            }
        }
        return max;
    }

    public static int maxArea2(int[] height) {
        // 双指针
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
