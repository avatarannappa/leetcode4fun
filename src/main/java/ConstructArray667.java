import java.util.Arrays;

/**
 * 667. 优美的排列 II
 * medium
 *
 * @author avatarannappa
 * @date 2022/9/8
 */
public class ConstructArray667 {

    public int[] constructArray(int n, int k) {
        // 找规律
        int[] ans = new int[n];
        int t = k - 1;
        int sign = 0;
        for (int i = 0; i < n; i++) {
            if (n - (i + 1) >= k) {
                ans[i] = i + 1;
            } else if (n - (i + 1) == k - 1) {
                ans[i] = n;
            } else {
                if (sign % 2 == 0) {
                    ans[i] = ans[i - 1] - t;
                } else {
                    ans[i] = ans[i - 1] + t;
                }
                sign++;
                t--;
            }
        }

        return ans;
    }

    public int[] constructArrayOld(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int[] ans = new int[n];
        int t = k - 1;
        int sign = 0;
        for (int i = 0; i < n; i++) {
            if (n - arr[i] >= k) {
                ans[i] = arr[i];
            } else if (n - arr[i] == k - 1) {
                ans[i] = n;
            } else {
                if (sign % 2 == 0) {
                    ans[i] = ans[i - 1] - t;
                } else {
                    ans[i] = ans[i - 1] + t;
                }
                sign++;
                t--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 10;
        int k = 9;
        System.out.println(Arrays.toString(new ConstructArray667().constructArray(n, k)));
    }
}
