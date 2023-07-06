import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 2178. 拆分成最多数目的正偶数之和
 * medium
 *
 * @author avatarannappa
 * @date 2023/7/6
 */
public class MaximumEvenSplit2178 {

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new LinkedList<>();

        if (finalSum % 2 != 0) {
            return res;
        }
        Set<Long> set = new HashSet<>();
        long now = 2;
        while (finalSum > 0 && !set.contains(finalSum)) {
            res.add(now);
            set.add(now);
            finalSum -= now;
            now += 2;
        }
        if (finalSum > 0) {
            long last = res.get(res.size() - 1) + finalSum;
            res.remove(res.size() - 1);
            res.add(last);
        }

        return res;
    }

    public static void main(String[] args) {
        long finalSum = 28;
        // 输出：[6,8,2,12]
        System.out.println(new MaximumEvenSplit2178().maximumEvenSplit(finalSum));
    }
}
