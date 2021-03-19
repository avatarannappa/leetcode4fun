import java.util.HashMap;
import java.util.Map;

/**
 * 748. 最短补全词
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/19
 */
public class ShortestCompletingWord748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (c >= 'a' && c <= 'z') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) (c - ('A' - 'a'));
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        String result = null;

        for (String word : words) {
            Map<Character, Integer> tempMap = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                Character cw = word.charAt(i);
                tempMap.put(cw, tempMap.getOrDefault(cw, 0) + 1);
            }
            boolean sign = true;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();
                if (!tempMap.containsKey(key) || tempMap.get(key) < value) {
                    sign = false;
                    break;
                }
            }
            if (sign && (result == null || result.length() > word.length())) {
                result = word;
            }
        }

        return result;
    }

    public boolean check(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            return map.get(c) >= 0;
        }
        return false;
    }

    public static void main(String[] args) {
        String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
        System.out.println(new ShortestCompletingWord748().shortestCompletingWord(licensePlate, words));
    }
}
