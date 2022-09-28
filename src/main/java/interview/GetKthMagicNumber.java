package interview;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 面试题 17.09. 第 k 个数
 * medium
 *
 * @author avatarnnappa
 * @date 2022/9/28
 */
public class GetKthMagicNumber {

    public int getKthMagicNumber(int k) {
        // DP, O(k)
        int[] arr = new int[k + 4];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 5;
        arr[3] = 7;
        for (int i = 4, x = 1, y = 2, z = 3; i < k; i++) {
            int a = arr[x] * 3;
            int b = arr[y] * 5;
            int c = arr[z] * 7;
            int min = Math.min(a, Math.min(b, c));
            arr[i] = min;
            if (a == min) {
                x++;
            }
            if (b == min) {
                y++;
            }
            if (c == min) {
                z++;
            }
        }
        return arr[k - 1];
    }

    public int getKthMagicNumberOld(int k) {
        // 优先队列/小堆，O(klogk)
        int[] mask = new int[]{3, 5, 7};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.add(1L);
        set.add(1L);
        int index = 1;
        while (!queue.isEmpty()) {
            long num = queue.poll();
            if (index++ == k) {
                return (int) num;
            }
            for (int i : mask) {
                long temp = i * num;
                if (!set.contains(temp)) {
                    queue.add(temp);
                    set.add(temp);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int k = 8;
        // 1，3，5，7，9，15，21, 25, 27, 35, 45, 49, 63
        // 25
        System.out.println(new GetKthMagicNumber().getKthMagicNumber(k));
    }
}
