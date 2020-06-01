/**
 * 74. 搜索二维矩阵
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/1
 */
public class SearchMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int r = n * m - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int y = mid / m;
            int x = mid % m;
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}};
        int target = 2;
        System.out.println(new SearchMatrix74().searchMatrix(matrix, target));
    }
}
