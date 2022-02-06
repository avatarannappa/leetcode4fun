import java.util.*;
import java.util.stream.Collectors;

/**
 * 1405. 最长快乐字符串.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/2/7
 */
public class LongestDiverseString1405 {

    public String longestDiverseString(int a, int b, int c) {
        // 贪心，排序
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new TreeMap<>();
        map.put('a', a);
        map.put('b', b);
        map.put('c', c);
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
        while (true) {
            list = list.stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
            boolean end = true;
            for (int i = list.size() - 1; i >= 0; i--) {
                Map.Entry<Character, Integer> entry = list.get(i);
                if (entry.getValue() <= 0) {
                    break;
                }
                int len = sb.length();
                if (len >= 2 && sb.charAt(len -1) == entry.getKey() && sb.charAt(len - 2) == entry.getKey()) {
                    continue;
                }
                end = false;
                sb.append(entry.getKey());
                entry.setValue(entry.getValue()-1);
                break;
            }
            if (end) {
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongestDiverseString1405().longestDiverseString(7, 1, 0));
    }

}
