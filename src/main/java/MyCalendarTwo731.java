import java.util.Map;
import java.util.TreeMap;

/**
 * 731. 我的日程安排表 II
 * medium
 *
 * @author avatarannappa
 * @date 2022/7/19
 */
public class MyCalendarTwo731 {


    public MyCalendarTwo731() {
    }

    TreeMap<Integer, Integer> cntMap = new TreeMap<Integer, Integer>();

    public boolean book(int start, int end) {
        // 差分数组思想。
        // 数组开头+1，数组结尾-1，抵消开头。先把book放进去，每一个算一下（预定数为从treeMap从小到大的和）
        // TODO 线段树
        int book = 0;
        cntMap.put(start, cntMap.getOrDefault(start, 0) + 1);
        cntMap.put(end, cntMap.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int freq = entry.getValue();
            book += freq;
            if (book > 2) {
                cntMap.put(start, cntMap.getOrDefault(start, 0) - 1);
                cntMap.put(end, cntMap.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }

}
