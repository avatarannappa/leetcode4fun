/**
 * 2614. 对角线上的质数.
 * easy
 *
 * @author avatarannappa
 * @version 2025/3/18
 */
public class DiagonalPrime2614 {

    int len = 4000001;
    private boolean[] mask = new boolean[len];

    public int diagonalPrime(int[][] nums) {
        // 这里用了埃氏筛
        // 因为nums不大，可以直接求是不是质数nlog(根号m)
        init();
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i][i];
            if (isPrime(num)) {
                ans = Math.max(ans, num);
            }
            // 另一条对角线
            num = nums[i][i];
            if (isPrime(num)) {
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }

    public void init() {
        // 埃氏筛法
        mask[0] = true;
        mask[1] = true;
        for (int i = 2; i * i < len; i++) {
            if (mask[i]) {
                continue;
            }
            for (int j = i * i; j < len; j += i) {
                mask[j] = true;
            }
        }
    }

    public boolean isPrime(int num) {
        return !mask[num];
    }

    public static void main(String[] args) {
        DiagonalPrime2614 dp = new DiagonalPrime2614();
        dp.init();
        System.out.println(dp.isPrime(883));
    }
}
