import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2831. 找出最长等值子数组
 * medium
 *
 * @author avatarannappa
 * @date 2024/5/23
 */
public class LongestEqualSubarray2831 {

    public int longestEqualSubarray(List<Integer> nums, int k) {
        // 分组+滑动窗口
        int res = 0;
        int n = nums.size();
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 分组
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            List<Integer> l = map.getOrDefault(num, new ArrayList<>());
            l.add(i);
            map.put(num, l);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> indexList = entry.getValue();
            if (indexList.size() <= res) {
                continue;
            }
            // 滑动窗口
            int l = 0;
            for (int r = 0; r < indexList.size(); r++) {
                while (indexList.get(r) - indexList.get(l) - r + l > k) {
                    l++;
                }
                res = Math.max(res, r - l + 1);
            }
        }

        return res;
    }

    public int longestEqualSubarrayOld(List<Integer> nums, int k) {
        // 超时
        int res = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int len = 0;
            int t = k;
            for (int j = i + 1; j < n && t >= 0; j++) {
                if (nums.get(i).equals(nums.get(j))) {
                    len++;
                } else {
                    t--;
                }
            }
            res = Math.max(res, len + 1);

        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 1, 2, 2, 1, 1);
        int k = 2;
        // 4
        System.out.println(new LongestEqualSubarray2831().longestEqualSubarray(nums, k));
    }
}
