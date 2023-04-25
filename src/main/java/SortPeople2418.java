import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2418. 按身高排序
 * easy
 *
 * @author avatarannappa
 * @date 2023/4/25
 */
public class SortPeople2418 {

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            map.put(heights[i], i);
        }

        String[] result = new String[n];
        int i = 0;
        for (Integer j : map.values()) {
            result[i] = names[j];
            i++;
        }
        return result;
    }

}
