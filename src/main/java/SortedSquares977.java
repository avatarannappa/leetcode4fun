import java.util.Arrays;

/**
 * 977. 有序数组的平方
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/20
 */
public class SortedSquares977 {

    public int[] sortedSquares(int[] A) {
        int[] b = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            b[i] = A[i] * A[i];
        }
        Arrays.sort(b);
        return b;
    }

}
