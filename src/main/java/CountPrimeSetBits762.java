import java.util.HashSet;
import java.util.Set;

/**
 * 762. 二进制表示中质数个计算置位.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/4/6
 */
public class CountPrimeSetBits762 {

    Set<Integer> primes = new HashSet<>();

    public int countPrimeSetBits(int L, int R) {
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        primes.add(19);
        primes.add(23);
        primes.add(29);
        primes.add(31);
        primes.add(37);
        primes.add(41);
        primes.add(43);
        primes.add(47);
        primes.add(53);
        primes.add(59);
        primes.add(61);
        primes.add(67);
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return primes.contains(count);
    }

    public static void main(String[] args) {
        CountPrimeSetBits762 countPrimeSetBits762 = new CountPrimeSetBits762();
        System.out.println(countPrimeSetBits762.countPrimeSetBits(6, 10));
    }
}
