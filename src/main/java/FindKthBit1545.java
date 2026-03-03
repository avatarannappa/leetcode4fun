/**
 * 1545. Find Kth Bit in Nth Binary String.
 * medium
 *
 * @author avatarannappa
 * @since 2026/3/3
 */
public class FindKthBit1545 {

    public char findKthBitNew(int n, int k) {
        if (k % 2 > 0) {
            return (char) ('0' + k / 2 % 2);
        }
        k /= k & -k; // 去掉 k 的尾零
        return (char) ('1' - k / 2 % 2);
    }

    public char findKthBit(int n, int k) {
        String s = genString(n);
        return s.charAt(k - 1);
    }

    public String genString(int n) {
        if (n == 1) {
            return "0";
        }
        String left = genString(n - 1);
        String right = new StringBuilder(invert(left)).reverse().toString();
        return left + "1" + right;
    }

    public String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == '0' ? '1' : '0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 11;
        // 1
        System.out.println(new FindKthBit1545().findKthBit(n, k));
    }
}
