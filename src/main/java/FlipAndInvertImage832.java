/**
 * 832. 翻转图像.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/10
 */
public class FlipAndInvertImage832 {

    public int[][] flipAndInvertImage(int[][] A) {
        int len = A.length;
        int last = len - 1;
        if (len % 2 == 0) {
            // even
            for (int col = 0; col < len; col++) {
                for (int i = 0; i < len / 2; i++) {
                    int temp = A[col][i] ^ 1;
                    A[col][i] = A[col][last - i] ^ 1;
                    A[col][last - i] = temp;
                }
            }
        } else {
            // odd
            for (int col = 0; col < len; col++) {
                for (int i = 0; i < len / 2; i++) {
                    int temp = A[col][i] ^ 1;
                    A[col][i] = A[col][last - i] ^ 1;
                    A[col][last - i] = temp;
                }
                A[col][last / 2] = A[col][last / 2] ^ 1;
            }
        }
        return A;
    }
}
