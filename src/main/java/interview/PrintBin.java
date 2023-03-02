package interview;

/**
 * 面试题 05.02. 二进制数转字符串
 * medium
 *
 * @author avatarannappa
 * @date 2023/3/2
 */
public class PrintBin {

    public String printBin(double num) {
        // 二进制表示小数，数学
        String ans = "0.";

        while (ans.length() <= 32 && num != 0) {
            num *= 2;
            int a = (int) num;
            ans += a;
            num -= a;
        }

        return ans.length() <= 32 ? ans : "ERROR";
    }

    public String printBinNew(double num) {
        // 优化至多循环6次
        // 除了5，其他数乘以2末尾数字相同，循环节都小于等于6
        StringBuilder bin = new StringBuilder("0.");
        for (int i = 0; i < 6; ++i) {
            num *= 2;
            if (num < 1) {
                bin.append('0');
            } else {
                bin.append('1');
                if (--num == 0) {
                    return bin.toString();
                }
            }
        }
        return "ERROR";
    }


    public static void main(String[] args) {
        double num = 0.625;
        // 0.101
        System.out.println(new PrintBin().printBin(num));
    }
}
