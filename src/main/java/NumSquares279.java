import java.util.LinkedList;
import java.util.Queue;

/**
 * 279. 完全平方数
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/4
 */
public class NumSquares279 {

    public int numSquares(int n) {
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            for (int j = 1; j * j <= i; j++) {
                arr[i] = Math.min(arr[i], arr[i - j * j] + 1);
            }
        }

        return arr[n];
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(new NumSquares279().numSquares(n));
    }
}
