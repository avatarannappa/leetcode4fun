import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. 根据字符出现频率排序,
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/18
 */
public class FrequencySort451 {

    public String frequencySort(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.merge(c, 1, (o, n) -> o + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> o2.getValue() - o1.getValue());
        priorityQueue.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> entry = priorityQueue.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    public static class Tuple {
        char key;
        int count;

        public Tuple(char key, int count) {
            this.key = key;
            this.count = count;
        }
    }
}
