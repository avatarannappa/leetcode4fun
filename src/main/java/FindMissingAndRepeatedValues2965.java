/**
 * 2965. 找出缺失和重复的数字
 * easy
 *
 * @author avatarnnappa
 * @date 2024/5/31
 */
public class FindMissingAndRepeatedValues2965 {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // 简单模拟
        int[] res = new int[2];

        int n = grid.length;
        int[] arr = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[grid[i][j] - 1]++;
            }
        }

        for (int i = 0; i < n * n; i++) {
            if (arr[i] == 2) {
                res[0] = i + 1;
            } else if (arr[i] == 0) {
                res[1] = i + 1;
            }
        }

        return res;
    }

}
