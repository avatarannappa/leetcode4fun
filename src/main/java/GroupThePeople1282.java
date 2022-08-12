import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 1282. 用户分组
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/12
 */
public class GroupThePeople1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // 简单模拟. 数组、Map
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new LinkedList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int group = groupSizes[i];
            List<Integer> temp = map.getOrDefault(group, new LinkedList<>());
            temp.add(i);
            map.put(group, temp);
            if (temp.size() == group) {
                ans.add(temp);
                map.remove(group);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        // [[5],[0,1,2],[3,4,6]]
        //  [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]
        System.out.println(new GroupThePeople1282().groupThePeople(groupSizes));
    }
}
