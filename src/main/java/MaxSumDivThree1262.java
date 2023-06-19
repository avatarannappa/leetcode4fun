import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 1262. 可被三整除的最大和
 * medium
 *
 * @author avatarannappa
 * @date 2023/6/19
 */
public class MaxSumDivThree1262 {


    public int maxSumDivThree(int[] nums) {
        // 贪心
        // TODO DP
        int ans = 0;

        for (int num : nums) {
            ans += num;
        }

        if (ans % 3 == 0) {
            return ans;
        }

        List<Integer> a1 = new LinkedList<>();
        List<Integer> a2 = new LinkedList<>();
        for (int num : nums) {
            if (num % 3 == 1) {
                a1.add(num);
            } else if (num % 3 == 2) {
                a2.add(num);
            }
        }
        Collections.sort(a1);
        Collections.sort(a2);

        if (ans % 3 == 2) {
            // swap(a1,a2)
            List<Integer> tmp = a1;
            a1 = a2;
            a2 = tmp;
        }

        int res = a1.isEmpty() ? 0 : ans - a1.get(0);
        if (a2.size() > 1) {
            res = Math.max(res, ans - a2.get(0) - a2.get(1));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4};
        System.out.println(new MaxSumDivThree1262().maxSumDivThree(nums));
    }
}
