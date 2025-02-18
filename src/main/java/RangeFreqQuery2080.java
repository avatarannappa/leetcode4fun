import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2080. 区间内查询数字的频率.
 * medium
 *
 * @author avatarannappa
 * @version 2025/2/18
 */
public class RangeFreqQuery2080 {

    Map<Integer, List<Integer>> map = new HashMap<>();

    public RangeFreqQuery2080(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
    }

    public int query(int left, int right, int value) {
        // 哈希表+二分
        List<Integer> list = map.get(value);
        if (list == null) {
            return 0;
        }
        int r = findLow(list, right);
        int l = findHight(list, left);
        return l < r ? r - l - 1 : 0;
    }

    public int findLow(List<Integer> list, int target) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int findHight(List<Integer> list, int target) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }


    public static void main(String[] args) {
        // [[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]] 输出： [null, 1, 2]
        RangeFreqQuery2080 rangeFreqQuery2080 = new RangeFreqQuery2080(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        System.out.println(rangeFreqQuery2080.query(0, 2, 4));
    }

}
