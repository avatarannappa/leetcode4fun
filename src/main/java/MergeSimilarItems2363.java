import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 2363. 合并相似的物品
 * easy
 *
 * @author avatarannappa
 * @date 2023/2/28
 */
public class MergeSimilarItems2363 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans = new LinkedList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] ints : items1) {
            map.put(ints[0], ints[1]);
        }
        for (int[] ints : items2) {
            int v = ints[0];
            int w = map.getOrDefault(v, 0);
            map.put(v, w + ints[1]);
        }

        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            List<Integer> t = new LinkedList<>();
            t.add(en.getKey());
            t.add(en.getValue());
            ans.add(t);
        }
        ans.sort(Comparator.comparingInt(o -> o.get(0)));

        return ans;
    }

    public static void main(String[] args) {
        int[][] items1 = {{1, 1}};
        int[][] items2 = {{1, 5}};
        System.out.println(new MergeSimilarItems2363().mergeSimilarItems(items1, items2));
    }
}
