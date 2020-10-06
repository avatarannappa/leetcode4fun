import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/6
 */
public class FractionToDecimal166 {
    public String fractionToDecimal(int numerator, int denominator) {
        // 分数是有限小数或无限循环小数
        // 证明：抽屉原理，循环节<denominator
        // 小数化分数，一元方程
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(dividend / divisor);
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                // insert index
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            // 记录数字index
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(remainder / divisor);
            remainder %= divisor;
        }
        return fraction.toString();
    }

    public static void main(String[] args) {
        int numerator = 131;
        int denominator = 23;
        System.out.println(new FractionToDecimal166().fractionToDecimal(numerator, denominator));
    }
}
