import java.util.Arrays;

/**
 * 1806. 还原排列的最少操作步数
 * medium
 *
 * @author avatarannappa
 * @date 2023/1/9
 */
public class ReinitializePermutation1806 {

    public int reinitializePermutation(int n) {
        // 数学 O(n)
        // 欧拉定理 & 费马小定理：https://oi-wiki.org/math/number-theory/fermat/
        // 欧拉函数：https://oi-wiki.org/math/number-theory/euler/
        if (n == 2) {
            return 1;
        }
        int mod = n - 1;
        int step = 1, pow2 = 2;
        while (pow2 != 1) {
            step++;
            pow2 = pow2 * 2 % mod;
        }
        return step;
    }

    public int reinitializePermutationOld(int n) {
        // 模拟
        int[] perm = new int[n];
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            target[i] = i;
        }
        int step = 0;
        while (true) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if ((i & 1) != 0) {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                } else {
                    arr[i] = perm[i / 2];
                }
            }
            perm = arr;
            step++;
            if (Arrays.equals(perm, target)) {
                break;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int n = 4;
        // 2
        // 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
        // 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
        System.out.println(new ReinitializePermutation1806());
    }
}
