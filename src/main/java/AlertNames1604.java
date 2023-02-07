import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1604. 警告一小时内使用相同员工卡大于等于三次的人
 * medium
 *
 * @author avatarannappa
 * @date 2023/2/7
 */
public class AlertNames1604 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        // 哈希表，超时
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String[] arr = keyTime[i].split(":");
            Integer time = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
            Map.Entry<String, Integer> entry = new AbstractMap.SimpleEntry<>(name, time);
            entryList.add(entry);
        }
        entryList.sort(Comparator.comparingInt(Map.Entry::getValue));

        Map<String, List<Integer>> map = new HashMap<>();
        Set<String> ans = new HashSet<>();

        for (int i = 0; i < keyName.length; i++) {
            Map.Entry<String, Integer> entry = entryList.get(i);
            String name = entry.getKey();
            Integer time = entry.getValue();
            if (ans.contains(name)) {
                continue;
            }
            List<Integer> timeList = map.getOrDefault(name, new LinkedList<>());
            timeList.add(time);
            if (timeList.size() > 2) {
                int j = timeList.size() - 1;
                if (timeList.get(j) - timeList.get(j - 2) <= 60) {
                    ans.add(name);
                }
            }
            map.put(name, timeList);
        }
        return ans.stream().sorted().collect(Collectors.toList());
    }

    public List<String> alertNamesNew(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> timeMap = new HashMap<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            timeMap.putIfAbsent(name, new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            timeMap.get(name).add(hour * 60 + minute);
        }
        List<String> res = new ArrayList<>();
        Set<String> keySet = timeMap.keySet();
        for (String name : keySet) {
            List<Integer> list = timeMap.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                int time1 = list.get(i - 2), time2 = list.get(i);
                int difference = time2 - time1;
                if (difference <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        String[] keyName = {"a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b"};
        String[] keyTime = {"04:48", "23:53", "06:36", "07:45", "12:16", "00:52", "10:59", "17:16", "00:36", "01:26",
            "22:42"};
        // ["b"]
        System.out.println(new AlertNames1604().alertNames(keyName, keyTime));
    }
}
