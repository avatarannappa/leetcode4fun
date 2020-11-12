/**
 * 661. 图片平滑器
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/12
 */
public class ImageSmoother661 {

    public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int temp = M[i][j];
                int count = 1;
                if (i > 0) {
                    temp += M[i - 1][j];
                    count++;
                    if (j > 0) {
                        temp += M[i - 1][j - 1];
                        count++;
                    }
                    if (j < M[0].length - 1) {
                        temp += M[i - 1][j + 1];
                        count++;
                    }
                }
                if (i < M.length - 1) {
                    temp += M[i + 1][j];
                    count++;
                    if (j > 0) {
                        temp += M[i + 1][j - 1];
                        count++;
                    }
                    if (j < M[0].length - 1) {
                        temp += M[i + 1][j + 1];
                        count++;
                    }
                }
                if (j > 0) {
                    temp += M[i][j - 1];
                    count++;
                }
                if (j < M[0].length - 1) {
                    temp += M[i][j + 1];
                    count++;
                }
                result[i][j] = temp / count;
            }
        }
        return result;
    }

}
