import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/7
 */
public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (String str : strs) {
            String temp = sort(str);
            if (map.containsKey(temp)) {
                result.get(map.get(temp)).add(str);
            } else {
                map.put(temp, index);
                List<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);
                index++;
            }
        }
        return result;
    }

    public String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams49().groupAnagrams(strs));
    }
}
