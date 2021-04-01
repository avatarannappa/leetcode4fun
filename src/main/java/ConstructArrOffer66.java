import java.util.Arrays;

/**
 * 剑指 Offer 66. 构建乘积数组
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/1
 */
public class ConstructArrOffer66 {

    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int[] result = new int[a.length];
        int[] left = new int[a.length];
        left[0] = 1;
        int[] right = new int[a.length];
        right[0] = 1;
        for (int i = 0; i < a.length - 1; i++) {
            left[i + 1] = left[i] * a[i];
            right[i + 1] = right[i] * a[a.length - 1 - i];
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = left[i] * right[a.length - 1 - i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new ConstructArrOffer66().constructArr(a)));
    }
}
