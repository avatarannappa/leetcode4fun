import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 347. 前K个高频元素
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/13
 */
public class TopKFrequent347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int temp : nums) {
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        List<int[]> list = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] tuple = new int[2];
            tuple[0] = entry.getKey();
            tuple[1] = entry.getValue();
            list.add(tuple);
        }
        list.sort((o1, o2) -> o2[1] - o1[1]);
        List<Integer> result = new LinkedList<>();
        for (int[] tuple : list) {
            result.add(tuple[0]);
        }
        return result.subList(0, k);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(new TopKFrequent347().topKFrequent(nums, k));
    }
}
