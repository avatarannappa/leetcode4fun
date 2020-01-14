/**
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * @author avatarannappa
 * @version 1.0, 2019/6/14
 */
public class MyAtoi8 {
    public static void main(String[] args) {
        /*String s1 = "42";
        System.out.println(myAtoi(s1));
        String s2 = "   -42";
        System.out.println(myAtoi(s2));
        String s3 = "4193 with words";
        System.out.println(myAtoi(s3));
        String s4 = "    +0 123";
        System.out.println(myAtoi(s4));
        String s5 = "-2147483649";
        String s6 = "-2147483649";
        System.out.println(myAtoi(s5));
        System.out.println(Integer.valueOf('0'));
        System.out.println(Integer.valueOf('1'));
        System.out.println(Integer.valueOf('9'));*/

        String s4 = "2147483648";
        System.out.println(myAtoi(s4));
    }

    public static int myAtoi(String str) {
        int activeQuotient = ((1 << 31) - 1) / 10;
        int activeRemainder = ((1 << 31) - 1) % 10;
        int negitiveQuotient = (-1 << 31) / 10;
        int negitiveRemainder = (-1 << 31) % 10;
        int result = 0;
        str = str.trim();
        if (str.length() == 0) {
            return result;
        }

        // 是否首字母
        boolean firstChar = true;
        // stringbuilder，记录结果字符串
        StringBuilder num = new StringBuilder();
        // true正，false负
        boolean active = true;
        // 是否有有效数字，防止integer.valueof异常
        boolean hasNumber = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (firstChar) {
                firstChar = false;
                if (c == '+') {
                } else if (c == '-') {
                    active = false;
                    num.append(c);
                } else if (c >= '0' && c <= '9') {
                    num.append(c);
                    hasNumber = true;
                } else {
                    break;
                }

            } else {
                if (c >= '0' && c <= '9') {
                    hasNumber = true;
                    if (num.toString().length() > 2) {
                        result = Integer.valueOf(num.toString());
                    }
                    if (active && (result > activeQuotient || (result == activeQuotient
                                                                       && Integer.valueOf(String.valueOf(c))
                                                                                  > activeRemainder))) {
                        // 判断溢出
                        return (1 << 31) - 1;
                    }
                    if (!active && (result < negitiveQuotient || (result == negitiveQuotient
                                                                          && -Integer.valueOf(String.valueOf(c))
                                                                                     < negitiveRemainder))) {
                        return -1 << 31;
                    }
                    num.append(c);
                } else {
                    break;
                }
            }
        }
        if (num.toString().length() > 0 && hasNumber) {
            result = Integer.valueOf(num.toString());
        }
        return result;
    }
}
