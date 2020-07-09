/**
 * 509. 斐波那契数.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/9
 */
public class Fib509 {

    public int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N < 3) {
            return 1;
        }
        int[] array = new int[N];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < N; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[N - 1];
    }

    public static void main(String[] args) {
        int N = 4;
        System.out.println(new Fib509().fib(N));
    }
}
