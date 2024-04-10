/**
 * 1702. 修改后的最大二进制字符串
 * medium
 *
 * @author avatarannappa
 * @date 2024/4/10
 */
public class MaximumBinaryString1702 {

    public String maximumBinaryString(String binary) {
        // 贪心
        int n = binary.length();
        char[] s = binary.toCharArray();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                while (j <= i || (j < n && s[j] == '1')) {
                    j++;
                }
                if (j < n) {
                    s[j] = '1';
                    s[i] = '1';
                    s[i + 1] = '0';
                }
            }
        }
        return new String(s);
    }

    public static void main(String[] args) {
        // rules: 00 -> 10 , 10 -> 01
        String binary = "000110";
        // result:111011
        System.out.println(new MaximumBinaryString1702().maximumBinaryString(binary));
    }
}
