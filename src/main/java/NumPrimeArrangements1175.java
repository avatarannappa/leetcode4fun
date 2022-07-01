import java.util.HashMap;
import java.util.Map;

/**
 * 1175. 质数排列
 * easy
 *
 * @author avatarannappa
 * @date 2022/7/1
 */
public class NumPrimeArrangements1175 {

    private static int MOD = (int) 1e9 + 7;
    private static Map<Integer, Integer> map = new HashMap<>();
    private static int[] notPrimes = new int[101];
    private static int[] primes = new int[101];

    static {
        for (int i = 2; i <= 50; i++) {
            for (int j = 2; j <= 10; j++) {
                int temp = j * i;
                if (temp > 100) {
                    break;
                }
                notPrimes[temp] = temp;
            }
        }
        map.put(1, 0);
        for (int i = 2; i < notPrimes.length; i++) {
            if (notPrimes[i] == 0) {
                map.put(i, map.get(i - 1) + 1);
            } else {
                map.put(i, map.get(i - 1));
            }
        }
    }

    public int numPrimeArrangements(int n) {
        // 质数数量计算，排列
        int pc = map.get(n);
        int npc = n - pc;

        long ans = 1;
        for (int i = 2; i <= pc; i++) {
            ans = ans * i % MOD;
        }
        for (int i = 2; i <= npc; i++) {
            ans = ans * i % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int n = 100;
        // 5:12, 100:682289015
        System.out.println(new NumPrimeArrangements1175().numPrimeArrangements(n));
    }

}
