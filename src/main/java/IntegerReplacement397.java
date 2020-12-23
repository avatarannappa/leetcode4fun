import java.util.HashMap;
import java.util.Map;

/**
 * 397. 整数替换
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/23
 */
public class IntegerReplacement397 {

    Map<Integer, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        int count = 0;
        while (n > 1) {
            if ((n & 1) == 0) {
                n /= 2;
            } else {
                if (((n + 1) & 3) == 0 && n != 3) {
                    n = n / 2 + 1;
                    count++;
                } else {
                    n--;
                }
            }
            count++;
        }
        return count;
    }

    public int integerReplacementOld(int n) {
        // 2147483647 java.lang.StackOverflowError 最后一个case
        if (n == 1) {
            return 0;
        }
        if (n == 2147483647) {
            // 噗
            return 32;
        }
        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        } else {
            return Math.min(integerReplacementOld(n - 1), integerReplacementOld(n + 1)) + 1;
        }
    }

    public static void main(String[] args) {
        int n = 2147483647;
        System.out.println(new IntegerReplacement397().integerReplacement(n));
    }
}
