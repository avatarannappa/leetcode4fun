/**
 * 769. 最多能完成排序的块.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/13
 * @see MaxChunksToSorted768
 */
public class MaxChunksToSorted769 {

    public int maxChunksToSorted(int[] arr) {
        // O(n) 模拟。一个范围内，最小值和最大值等于开始和结束下标，则分成一个块。如：index [2, 4] 中数字是 [4, 3, 2]
        int n = arr.length;
        int ans = 0;
        int cur = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (num == i) {
                if (cur == i) {
                    ans++;
                    cur++;
                }
            } else {
                if (num < i) {
                    min = Math.min(min, num);
                } else {
                    max = Math.max(max, num);
                }
                if (min == cur && max == i) {
                    ans++;
                    cur = i + 1;
                    min = Integer.MAX_VALUE;
                    max = 0;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // int[] arr = {1, 0, 2, 3, 4};
        // 4
        int[] arr = {1, 0, 4, 3, 2};
        // 2
        // int[] arr = { 4, 3, 2, 1, 0 };
        // 1
        System.out.println(new MaxChunksToSorted769().maxChunksToSorted(arr));
    }
}
