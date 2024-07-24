import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2766. 重新放置石块
 * medium
 *
 * @author avatarannappa
 * @date 2024/7/24
 */
public class RelocateMarbles2766 {

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            int from = moveFrom[i];
            int to = moveTo[i];
            set.remove(from);
            set.add(to);
        }
        List<Integer> res = new ArrayList<>(set);
        res.sort(Integer::compareTo);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 7, 8}, moveFrom = {1, 7, 2}, moveTo = {2, 9, 5};
        // 输出：[5,6,8,9]
        System.out.println(new RelocateMarbles2766().relocateMarbles(nums, moveFrom, moveTo));
    }
}
