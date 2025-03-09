import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

import org.codehaus.groovy.runtime.ArrayUtil;

import utils.Array2ListUtil;

/**
 * 2070. 每一个查询的最大美丽值.
 * medium
 * 
 * @author avatarannappa
 * @version 1.0, 2025/03/09
 */
public class MaximumBeauty2070 {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        // 排序+二分查找
        int n = items.length;
        int m = queries.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            q.add(items[i]);
        }
        int max = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int[] arr = q.poll();
            max = Math.max(max, arr[1]);
            map.put(arr[0], max);
        }
        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            Integer key = map.floorKey(queries[i]);
            if (key == null) {
                res[i] = 0;
            } else {
                res[i] = map.get(key);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String items = "[[1,2],[3,2],[2,4],[5,6],[3,5]]";
        int[] queries = {1,2,3,4,5,6};
        Integer[][] itemsArray = Array2ListUtil.string2Int2DArray(items);
        int[][] itemsArray2 = Array2ListUtil.convertToPrimitive2d(itemsArray);
        // 输出：[2,4,5,5,6,6]
        System.out.println(Arrays.toString(new MaximumBeauty2070().maximumBeauty(itemsArray2, queries)));
    }
}
