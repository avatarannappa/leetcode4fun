import java.util.Arrays;

/**
 * 面试题40. 最小的k个数.
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/20
 */
public class GetLeastNumbers40M {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 1, 2};
        int k = 3;
        System.out.println(Arrays.toString(new GetLeastNumbers40M().getLeastNumbers(arr, k)));
    }
}
