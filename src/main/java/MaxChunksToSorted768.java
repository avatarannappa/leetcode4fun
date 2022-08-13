import java.util.*;

/**
 * 768. 最多能完成排序的块II
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/13
 */
public class MaxChunksToSorted768 {

    public int maxChunksToSorted(int[] arr) {
        // 排序 贪心 O(nlogn)
        int res = 0;
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int y = sortedArr[i];
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 0) {
                cnt.remove(x);
            }
            cnt.put(y, cnt.getOrDefault(y, 0) - 1);
            if (cnt.get(y) == 0) {
                cnt.remove(y);
            }
            if (cnt.isEmpty()) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 1, 8, 1, 6, 5, 9, 7, 8};
        // 1

        // int[] arr = {1, 1, 0, 0, 1};
        // 2

        // int[] arr = {2,1,3,4,4};
        // 4, [2, 1], [3], [4], [4]
        System.out.println(new MaxChunksToSorted768().maxChunksToSorted(arr));
    }
}
