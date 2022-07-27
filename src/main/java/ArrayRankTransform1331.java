import java.util.*;
import java.util.stream.Collectors;

/**
 * 1331. 数组序号转换.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/7/28
 */
public class ArrayRankTransform1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] res = new int[arr.length];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        }
        List<Map.Entry> list = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        Integer pre = Integer.MIN_VALUE;
        for (int i = 0, j = 0; i < res.length; i++) {
            int key = (int) list.get(i).getKey();
            int val = (int) list.get(i).getValue();
            if (val == pre) {
                res[key] = j;
            } else {
                res[key] = ++j;
            }
            pre = val;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1};
        // 4,1,2,3
        System.out.println(Arrays.toString(new ArrayRankTransform1331().arrayRankTransform(arr)));
    }
}
