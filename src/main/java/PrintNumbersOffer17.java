import java.util.Arrays;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/24
 */
public class PrintNumbersOffer17 {

    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n);
        int[] result = new int[max - 1];
        for (int i = 1; i < max; i++) {
            result[i - 1] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(Arrays.toString(new PrintNumbersOffer17().printNumbers(n)));
    }

}
