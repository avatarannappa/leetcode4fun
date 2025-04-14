/**
 * 1534. 统计好三元组.
 * easy
 *
 * @author avatarannappa
 * @version 2025/4/14
 */
public class CountGoodTriplets1534 {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        // 模拟
        // TODO 前缀和 | 三指针
        int cnt = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
