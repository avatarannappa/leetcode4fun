import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 1447. 最简分数.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/2/10
 */
public class Simplifiedfractions1447 {

    public List<String> simplifiedFractions(int n) {
        List<String> res = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) {
                    res.add(j + "/" + i);
                }
            }
        }
        
        return res;
    }

    int gcd(int a, int b) {
        // 最大公约数，辗转相除，欧几里得算法
        // 最大公约数（Greatest Common Divisor）缩写为GCD。
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int n = 4;
        // 5个
        System.out.println(new Simplifiedfractions1447().simplifiedFractions(n));
        System.out.println(new Simplifiedfractions1447().gcd(2,4));
    }
}
