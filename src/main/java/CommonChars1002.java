import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1002. 查找常用字符
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/22
 */
public class CommonChars1002 {

    public List<String> commonChars(String[] A) {
        Map<Character, Integer> existMap = new HashMap<>();
        Map<Character, Integer> countMap = new HashMap<>();
        for (String s : A) {
            char[] array = s.toCharArray();
            Map<Character, Integer> temp = new HashMap<>();
            for (char c : array) {
                temp.put(c, temp.getOrDefault(c, 0) + 1);
            }
            for (char key : temp.keySet()) {
                existMap.put(key, existMap.getOrDefault(key, 0) + 1);
                if (countMap.containsKey(key)) {
                    countMap.put(key, Math.min(countMap.get(key), temp.get(key)));
                } else {
                    countMap.put(key, temp.get(key));
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (char c : existMap.keySet()) {
            if (existMap.get(c) == A.length) {
                for (int i = 0; i < countMap.get(c); i++) {
                    result.add(String.valueOf(c));
                }
            }
        }
        return result;
    }

}
