import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 440. 字典序的第K小数字
 * hard
 *
 * @author avatarannappa
 * @date 2022/8/29
 */
public class FindKthNumber440 {

    public int findKthNumber(int n, int k) {
        // (logn)^^2
        int curr = 1;
        k--;
        while (k > 0) {
            int step = getSteps(curr, n);
            if (step <= k) {
                curr++;
                k = k - step;
            } else {
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }

    public int getSteps(int curr, int n) {
        int step = 0;
        long start = curr;
        long end = curr;
        while (start <= n) {
            step += Math.min(n, end) - start + 1;
            start = start * 10;
            end = end * 10 + 9;
        }
        return step;
    }

    public int findKthNumberOld1(int n, int k) {
        // 超时
        // 719885387
        // 209989719
        long ans = 1;
        int index = 1;
        while (index < k) {
            if (ans * 10 <= n) {
                ans = ans * 10;
            } else if (ans + 1 <= n) {
                while ((ans + 1) % 10 == 0) {
                    ans = ans / 10;
                }
                ans = ans + 1;
            } else {
                while ((ans / 10 + 1) % 10 == 0) {
                    ans = ans / 10;
                }
                ans = ans / 10 + 1;
            }
            index++;
        }
        return (int) ans;
    }

    public int findKthNumberOld2(int n, int k) {
        // 超出内存限制 O(n)
        // n 4289384
        // k 1922239
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        return Integer.parseInt(list.get(k - 1));
    }

    public static void main(String[] args) {
        int n = 1001;
        int k = 20;
        // 114
        // 1, 10, 11, 12, 2, 3, 4, 5, 6, 7, 8, 9
        System.out.println(new FindKthNumber440().findKthNumberOld1(n, k));
        System.out.print("[");
        for (int i = 1; i <= 1001; i++) {
            System.out.print(new FindKthNumber440().findKthNumberOld2(n, i) + ", ");
        }
        System.out.println("]");
        System.out.println(new FindKthNumber440().findKthNumber(1001, 115));
    }
}
