import java.util.HashMap;
import java.util.Map;

/**
 * 2085. 统计出现过一次的公共字符串
 * easy
 *
 * @author avatarannappa
 * @date 2024/1/12
 */
public class CountWords2085 {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words1) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        Map<String, Integer> map2 = new HashMap<>();
        for (String w : words2) {
            map2.put(w, map2.getOrDefault(w, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (entry.getValue() == 1 && map.getOrDefault(entry.getKey(), 0) == 1) {
                ans++;
            }
        }
        return ans;
    }
}
