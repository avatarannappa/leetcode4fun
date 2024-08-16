import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 3117. 划分数组得到最小的值之和.
 * hard
 *
 * @author avatarannappa
 * @date 2024/8/16
 */
public class MinimumValueSum3117 {

    public int minimumValueSum(int[] nums, int[] andValues) {
        Map<Long, Integer> memo = new HashMap<>();
        int ans = dfs(0, 0, -1, nums, andValues, memo);
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

    private int dfs(int i, int j, int and, int[] nums, int[] andValues, Map<Long, Integer> memo) {
        int n = nums.length;
        int m = andValues.length;
        if (n - i < m - j) {
            // 剩余元素不足
            return Integer.MAX_VALUE / 2;
        }
        if (j == m) {
            // 分了 m 段
            return i == n ? 0 : Integer.MAX_VALUE / 2;
        }
        and &= nums[i];
        // 三个参数压缩成一个 long
        long mask = (long) i << 36 | (long) j << 32 | and;
        if (memo.containsKey(mask)) { // 之前计算过
            return memo.get(mask);
        }
        int res = dfs(i + 1, j, and, nums, andValues, memo); // 不划分
        if (and == andValues[j]) { // 划分，nums[i] 是这一段的最后一个数
            res = Math.min(res, dfs(i + 1, j + 1, -1, nums, andValues, memo) + nums[i]);
        }
        memo.put(mask, res); // 记忆化
        return res;
    }

    Map<String, Integer> map = new HashMap<>();

    public int minimumValueSumMy(int[] nums, int[] andValues) {
        // 记忆化搜索
        int res = dfs(nums, andValues, 0, 0, -1);
        return res >= Integer.MAX_VALUE / 2 ? -1 : res;
    }

    public int dfs(int[] nums, int[] andValues, int numIndex, int valueIndex, int and) {
        if (nums.length - numIndex < andValues.length - valueIndex) {
            return Integer.MAX_VALUE / 2;
        }
        if (valueIndex == andValues.length) {
            return numIndex == nums.length ? 0 : Integer.MAX_VALUE / 2;
        }
        and &= nums[numIndex];
        String key = numIndex + "#" + valueIndex + "#" + and;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int res = dfs(nums, andValues, numIndex + 1, valueIndex, and);
        if (and == andValues[valueIndex]) {
            res = Math.min(res, dfs(nums, andValues, numIndex + 1, valueIndex + 1, -1) + nums[numIndex]);
        }
        map.put(key, res);
        return res;
    }

    public static class Node {

        int numStart;
        int valueIndex;
        int now;
        long sum;

        public Node(int numStart, int valueIndex, int now, int[] endArray) {
            this.numStart = numStart;
            this.valueIndex = valueIndex;
            this.now = now;
            this.sum = 0;
            for (int i = 0; i < valueIndex; i++) {
                this.sum += endArray[i];
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return numStart == node.numStart && valueIndex == node.valueIndex && now == node.now && sum == node.sum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(numStart, valueIndex, now, sum);
        }
    }


    public static void main(String[] args) {
        int[] nums = {4, 8, 9};
        int[] andValues = {0};
        // 输出： 9
        System.out.println(new MinimumValueSum3117().minimumValueSum(nums, andValues));
    }
}
