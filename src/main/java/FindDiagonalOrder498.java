import java.util.Arrays;

/**
 * 498. 对角线遍历.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/5/7
 */
public class FindDiagonalOrder498 {

    int index = 0;
    int[][] dir = {{-1, 1}, {1, -1}};
    int[][] turns = {{1, 0}, {0, 1}};
    int[][] turns2 = {{1, -1}, {-1, 1}};

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];

        int i = 0;
        int j = 0;
        int k = 0;
        while (true) {
            if (i < 0 || i >= m || j < 0 || j >= n) {
                i = turns[index][0] + i;
                j = turns[index][1] + j;
                if (i < 0 || i >= m || j < 0 || j >= n) {
                    i = turns2[index][0] + i;
                    j = turns2[index][1] + j;
                }
                index = 1 - index;
            } else {
                result[k++] = mat[i][j];
                if (i == m - 1 && j == n - 1) {
                    break;
                }
                i = dir[index][0] + i;
                j = dir[index][1] + j;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        FindDiagonalOrder498 findDiagonalOrder498 = new FindDiagonalOrder498();
        int[] result = findDiagonalOrder498.findDiagonalOrder(mat);
        // [1,2,4,7,5,3,6,8,9]
        System.out.println(Arrays.toString(result));
    }
}
