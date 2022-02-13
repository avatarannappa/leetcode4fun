import java.util.Arrays;

/**
 * 1189. 气球的最大数量.
 * easy.
 *
 * @author avatarannappa
 * @version 1.0, 2022/2/13
 */
public class MaxNumberOfBalloons1189 {

    public int maxNumberOfBalloons(String text) {
        int[] array = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char now = text.charAt(i);
            if ('b' == now) {
                array[0]++;
            } else if ('a' == now) {
                array[1]++;
            } else if ('l' == now) {
                array[2]++;
            } else if ('o' == now) {
                array[3]++;
            } else if ('n' == now) {
                array[4]++;
            }
        }
        array[2] /= 2;
        array[3] /= 2;
        Arrays.sort(array);
        return array[0];
    }

}
