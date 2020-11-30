import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 767. 重构字符串
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/30
 */
public class ReorganizeString767 {

    public String reorganizeString(String S) {
        // S 只包含小写字母并且长度在[1, 500]区间内。
        // 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
        // 若可行，输出任意可行的结果。若不可行，返回空字符串。
        if (S == null || S.length() < 2) {
            return S;
        }
        int max = -1;
        int[] array = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int index = c - 'a';
            array[index]++;
            if (array[index] > max) {
                max = array[index];
            }
        }
        if (max > (S.length() - 1) / 2 + 1) {
            return "";
        }
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                map.put((char) ('a' + i), array[i]);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        System.out.println(list);
        char[] result = new char[S.length()];
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Character, Integer> entry = list.get(i);
            for (int j = 0; j < entry.getValue(); j++) {
                if (index >= S.length()) {
                    index = 1;
                }
                result[index] = entry.getKey();
                index += 2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "abbabbaaab";
        System.out.println(new ReorganizeString767().reorganizeString(S));
    }
}
