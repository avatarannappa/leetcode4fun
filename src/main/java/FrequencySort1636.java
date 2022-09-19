import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1636. 按照频率将数组升序排序
 * easy
 *
 * @author avatarannappa
 * @date 2022/9/19
 */
public class FrequencySort1636 {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().sorted(
                (o1, o2) -> o1.getValue() - o2.getValue() == 0 ? o2.getKey() - o1.getKey() : o1.getValue() - o2.getValue())
            .collect(Collectors.toList());

        int[] ans = new int[nums.length];

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            for (int j = 0; j < entry.getValue(); j++) {
                ans[i++] = entry.getKey();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        // 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
        // 输出：[5,-1,4,4,-6,-6,1,1,1]
        System.out.println(Arrays.toString(new FrequencySort1636().frequencySort(nums)));
    }
}
