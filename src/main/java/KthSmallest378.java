import java.util.Arrays;

/**
 * 378. 有序矩阵中第K小的元素
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/5
 */
public class KthSmallest378 {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] array = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i * n + j] = matrix[i][j];
            }
        }
        Arrays.sort(array);
        return array[k - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(new KthSmallest378().kthSmallest(matrix, k));
    }
}
