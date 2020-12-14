/**
 * 191. 位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 * @author avatarannappa
 * @version 1.0, 2019/10/26
 */
public class HammingWeight191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int weight = 0;
        String nStr = Integer.toBinaryString(n);
        for (int i = 0; i < nStr.length(); i++) {
            if (nStr.charAt(i) == '1') {
                weight++;
            }
        }
        return weight;
    }

    public int hammingWeightNew(int n) {
        // 不断翻转最后一位1，时间复杂度O(1)
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        HammingWeight191 h = new HammingWeight191();
        int param = 5;
        int result = h.hammingWeight(param);
        System.out.println(Integer.toBinaryString(param));
        System.out.println(result);
    }
}
