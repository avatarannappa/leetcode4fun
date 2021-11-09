import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/9
 */
public class LongestSubsequence1218 {

    public int longestSubsequence(int[] arr, int difference) {
        // DP with map
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            int value = map.getOrDefault(j, 0) + 1;
            ans = Math.max(value, ans);
            map.put(j + difference, value);
        }
        return ans;
    }

    public int longestSubsequenceOld(int[] arr, int difference) {
        // 超时
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int ans = 1;
        for (int i = 0; i < arr.length; i++) {
            int pre = arr[i];
            int len = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - pre == difference) {
                    len++;
                    pre = arr[j];
                }
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        int difference = -2;
        System.out.println(new LongestSubsequence1218().longestSubsequence(arr, difference));
    }
}
