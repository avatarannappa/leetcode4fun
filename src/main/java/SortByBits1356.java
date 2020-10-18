import java.util.Arrays;

/**
 * 1356. 根据数字二进制下 1 的数目排序.
 * easy.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/18
 */
public class SortByBits1356 {

    public int[] sortByBits(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = 100000 * Integer.bitCount(arr[i]) + arr[i];
        }
        Arrays.sort(result);
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] % 100000;
        }
        return result;
    }

}
