import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 313. 超级丑数. medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/10/26
 */
public class NthSuperUglyNumber313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        // DP O(n * primes.length)
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int[] points = new int[primes.length];
        Arrays.fill(points, 1);
        int[] mask = new int[primes.length];
        System.arraycopy(primes, 0, mask, 0, primes.length);

        for (int i = 2; i <= n; i++) {
            int min = Arrays.stream(mask).min().getAsInt();
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (mask[j] == min) {
                    points[j]++;
                    mask[j] = primes[j] * dp[points[j]];
                }
            }
        }
        return dp[n];
    }

    public int nthSuperUglyNumberOld(int n, int[] primes) {
        // 优先队列，超时 O(n * primes.length * log(n))
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.naturalOrder());
        Set<Long> set = new HashSet<>();
        queue.add(1L);
        set.add(1L);
        while (n > 0) {
            Long t = queue.poll();
            if (n == 1) {
                return t.intValue();
            }
            for (int p : primes) {
                Long q = t * p;
                if (!set.contains(q)) {
                    queue.add(q);
                    set.add(q);
                }
            }
            n--;
        }
        return 0;
    }

    public static void main(String[] args) {
        // 1 <= n <= 106
        // 1 <= primes.length <= 100
        // 2 <= primes[i] <= 1000
        // 题目数据 保证 primes[i] 是一个质数
        // primes 中的所有值都 互不相同 ，且按 递增顺序 排列
        int n = 12;
        int[] primes = { 2, 7, 13, 19 };
        System.out.println(new NthSuperUglyNumber313().nthSuperUglyNumber(n, primes));
    }
}
