import java.util.List;

/**
 * 2824. 统计和小于目标的下标对数目
 * easy
 *
 * @author avatarannappa
 * @date 2023/11/24
 */
public class CountPairs2824 {

    public int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) >= target) {
                    continue;
                }
                ans++;
            }
        }
        return ans;
    }
}
