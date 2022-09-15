import java.util.HashMap;
import java.util.Map;

/**
 * 474. 一和零
 * medium
 *
 * @author avatarannappa
 * @date 2022/9/15
 */
public class FindMaxForm474 {

    String[] strs;
    int[][] arr;
    int ans = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        // TODO DP
        this.strs = strs;
        arr = new int[strs.length][2];
        for (int i = 0; i < arr.length; i++) {
            String str = strs[i];
            int count0 = 0;
            int count1 = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
            arr[i][0] = count0;
            arr[i][1] = count1;
        }
        return recursion(0, 0, m, n);
    }

    Map<String, Integer> map = new HashMap<>();

    public int recursion(int index, int count, int m, int n) {
        // 记忆化搜索，勉强ac，超过5%
        if (m < 0 || n < 0) {
            return count - 1;
        }
        if (index == strs.length) {
            return count;
        }

        String key = index + "#" + count + "#" + m + "#" + n;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int a = recursion(index + 1, count + 1, m - arr[index][0], n - arr[index][1]);
        int b = recursion(index + 1, count, m, n);
        int res = Math.max(a, b);
        map.put(key, res);
        return res;
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        // 24/88 超时
        this.strs = strs;
        arr = new int[strs.length][2];
        for (int i = 0; i < arr.length; i++) {
            String str = strs[i];
            int count0 = 0;
            int count1 = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
            arr[i][0] = count0;
            arr[i][1] = count1;
        }
        recursion2(0, 0, m, n);
        return ans;
    }

    public void recursion2(int index, int count, int m, int n) {
        // 穷举，暴搜
        if (m < 0 || n < 0) {
            return;
        }
        if (index == strs.length) {
            ans = Math.max(ans, count);
            return;
        }

        recursion(index + 1, count + 1, m - arr[index][0], n - arr[index][1]);
        recursion(index + 1, count, m, n);
    }

    public static void main(String[] args) {
        // 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
        // 输出：4
        // 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
        // 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 4;
        int n = 3;
        System.out.println(new FindMaxForm474().findMaxForm(strs, m, n));
    }
}
