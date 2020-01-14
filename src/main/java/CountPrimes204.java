/**
 * 204. 计数质数
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/16
 */
public class CountPrimes204 {
    public int countPrimes(int n) {
        n = n - 1;
        if (n <= 1) {
            return 0;
        }
        int[] array = new int[n];
        int length = (int) Math.sqrt(n);

        for (int i = 2; i <= length; i++) {
            if (array[i - 1] == 0) {
                for (int j = i; j < n; j++) {
                    if (i * j > n) {
                        break;
                    }
                    array[i * j - 1] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 1; i < n; i++) {
            if (array[i] == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes204 c = new CountPrimes204();
        System.out.println(c.countPrimes(10));
    }
}
