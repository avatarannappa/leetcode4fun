import java.util.Arrays;

/**
 * 240. 搜索二维矩阵 II
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/6
 */
public class SearchMatrix240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[] array = new int[m * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i * m + j] = matrix[i][j];
            }
        }
        Arrays.sort(array);
        return binarySearch(array, target);
    }

    public boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int[][] matrix = {{-1}, {-1}};
        int target = 2;
        System.out.println(new SearchMatrix240().searchMatrix(matrix, target));
    }
}
