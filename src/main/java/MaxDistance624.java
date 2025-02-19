import java.util.List;
import utils.Array2ListUtil;

/**
 * 624. 数组列表中的最大距离.
 * medium
 *
 * @author avatarannappa
 * @version 2025/2/19
 */
public class MaxDistance624 {

    public int maxDistance(List<List<Integer>> arrays) {
        // 贪心，O(n). 如果要算同个一数组，则index从0开始
        if (arrays.size() < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int l = arrays.get(0).get(0);
        int r = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> t = arrays.get(i);
            int n = t.size() - 1;
            max = Math.max(max, Math.max(r - t.get(0), t.get(n) - l));
            l = Math.min(l, t.get(0));
            r = Math.max(r, t.get(n));
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "[[1,2,3],[4,5],[1,2,3]]";
        List<List<Integer>> arrays = Array2ListUtil.string2Int2DList(str);
        System.out.println(new MaxDistance624().maxDistance(arrays));
    }
}
