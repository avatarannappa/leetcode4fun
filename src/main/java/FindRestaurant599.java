import java.util.ArrayList;
import java.util.List;

/**
 * 599. 两个列表的最小索引总和.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/5
 */
public class FindRestaurant599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = 10000;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    int index = i + j;
                    if (index < min) {
                        min = index;
                        result.clear();
                        result.add(list1[i]);
                    } else if (index == min) {
                        result.add(list1[i]);
                    }
                }
            }
        }
        String[] arr = new String[result.size()];
        arr = result.toArray(arr);
        return arr;
    }

}
