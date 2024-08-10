import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2940. 找到 Alice 和 Bob 可以相遇的建筑
 * hard
 *
 * @author avatarannappa
 * @date 2024/8/10
 */
public class LeftmostBuildingQueries2940 {

    int[] mx;

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        // 线段树
        int n = heights.length;
        mx = new int[n * 4];
        build(1, n, 1, heights);

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            if (a == b || heights[a] < heights[b]) {
                ans[i] = b;
                continue;
            }

            ans[i] = query(b + 1, heights[a], 1, n, 1) - 1;
        }
        return ans;
    }

    public void build(int l, int r, int ind, int[] heights) {
        // 建树
        if (l == r) {
            mx[ind] = heights[l - 1];
            return;
        }

        int mid = (l + r) >> 1;
        int left = ind << 1;
        build(l, mid, left, heights);
        build(mid + 1, r, left + 1, heights);
        mx[ind] = Math.max(mx[left], mx[left + 1]);
    }

    public int query(int pos, int val, int l, int r, int ind) {
        if (val >= mx[ind]) {
            return 0;
        }

        if (l == r) {
            return l;
        }

        int mid = (l + r) >> 1;
        if (pos <= mid) {
            int res = query(pos, val, l, mid, ind << 1);
            if (res != 0) {
                return res;
            }
        }
        return query(pos, val, mid + 1, r, ind << 1 | 1);
    }

    public int[] leftmostBuildingQueriesOld(int[] heights, int[][] queries) {
        // 超时 939/951
        int[] result = new int[queries.length];
        Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.putIfAbsent(i, new TreeMap<>());
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[i] < heights[j]) {
                    map.get(i).put(j, heights[j]);
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == r) {
                result[i] = l;
                continue;
            }
            int ll = Math.min(l, r);
            int rr = Math.max(l, r);
            if (heights[ll] < heights[rr]) {
                // a 移动到 b
                result[i] = rr;
                continue;
            }
            Map.Entry<Integer, Integer> lEntry = map.get(ll).ceilingEntry(rr);
            Map.Entry<Integer, Integer> rEntry = map.get(rr).ceilingEntry(rr);
            if (lEntry == null || rEntry == null) {
                result[i] = -1;
            } else {
                int lIndex = lEntry.getKey();
                int lValue = lEntry.getValue();
                int rIndex = rEntry.getKey();
                int rValue = rEntry.getValue();
                if (lIndex < rIndex) {
                    if (lValue > heights[rr]) {
                        result[i] = lIndex;
                    } else {
                        result[i] = rIndex;
                    }
                } else {
                    if (rValue > heights[ll]) {
                        result[i] = rIndex;
                    } else {
                        result[i] = lIndex;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[][] queries = {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};
        int[] heights = {6, 4, 8, 5, 2, 7};
        // result:[2,5,-1,5,2]
        System.out.println(Arrays.toString(new LeftmostBuildingQueries2940().leftmostBuildingQueries(heights, queries)));
    }
}
