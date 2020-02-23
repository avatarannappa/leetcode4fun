import java.util.Arrays;

/**
 * 338. 比特位计数.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/23
 */
public class CountBits338 {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                // even
                result[i] = result[i / 2];
            } else {
                // odd
                result[i] = result[i - 1] + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountBits338().countBits(5)));
    }

}
