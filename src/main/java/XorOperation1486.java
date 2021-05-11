/**
 * 1486. 数组异或操作
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/11
 */
public class XorOperation1486 {

    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= start + 2 * i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int start = 0;
        System.out.println(new XorOperation1486().xorOperation(n, start));
    }
}
