package interview;

/**
 * 面试题 16.05. 阶乘尾数
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/20
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        // 小于n的数中质因子5的数量
        int ans = 0;
        while(n > 0) {
            n = n / 5;
            ans += n;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int n = 10;
        // 1
        System.out.println(new TrailingZeroes().trailingZeroes(n));
    }
}
