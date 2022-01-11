import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1995. 统计特殊四元组.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/11
 */
public class CountQuadruplets1995 {

    public int countQuadruplets(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int m = j + 1; m < nums.length; m++) {
                    for (int n = m + 1; n < nums.length; n++) {
                        if (nums[n] == nums[i] + nums[j] + nums[m]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 5};
        // 4
        System.out.println(new CountQuadruplets1995().countQuadruplets(nums));
        List<Integer> l = Lists.newArrayList(0,1,2,3,4);
        List<Integer> ans = new ArrayList<>();
        List<Integer> f = l.stream().limit(0).collect(Collectors.toList());
        ans.addAll(f);
        System.out.println(ans);
    }
}
