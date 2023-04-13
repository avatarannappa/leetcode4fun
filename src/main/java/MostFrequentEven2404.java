import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 2404. 出现最频繁的偶数元素
 * easy
 *
 * @author avatarannappa
 * @date 2023/4/13
 */
public class MostFrequentEven2404 {

    public int mostFrequentEven(int[] nums) {
        // 哈希表计数
        // 这里排序时间复杂度O(nlogn)，可以不用排序时间复杂度O(n)
        Map<Integer, int[]> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                int[] t = map.getOrDefault(num, new int[2]);
                t[0] = num;
                t[1] += 1;
                map.put(num, t);
            }
        }

        if (map.isEmpty()) {
            return -1;
        }

        List<int[]> l = map.values().stream().sorted((o1, o2) -> o2[1] - o1[1] == 0 ? o1[0] - o2[0] : o2[1] - o1[1])
            .collect(Collectors.toList());
        return l.get(0)[0];
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 4, 4, 1};
        System.out.println(new MostFrequentEven2404().mostFrequentEven(nums));
    }
}
