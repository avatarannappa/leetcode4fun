import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 1791. 找出星型图的中心节点.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/2/18
 */
public class Findcenter1791 {

    public int findCenter(int[][] edges) {
        // O(1) 星型，有重复点，且只有一个重复点。对比两条边就行了...
        return edges[1][0] == edges[0][0] || edges[1][1] == edges[0][0] ? edges[0][0] : edges[0][1];
    }

    public int findCenterOld(int[][] edges) {
        // O(nlogn)
        Map<Integer, Integer> tree = new HashMap<>();
        for (int[] edge : edges) {
            tree.put(edge[0], tree.getOrDefault(edge[0], 0) + 1);
            tree.put(edge[1], tree.getOrDefault(edge[1], 0) + 1);
        }
        List<Entry<Integer, Integer>> l = new ArrayList<>(tree.entrySet());
        l.sort((o1, o2) -> o2.getValue() - o1.getValue());
        return l.get(0).getKey();
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println(new Findcenter1791().findCenter(edges));
    }

}
