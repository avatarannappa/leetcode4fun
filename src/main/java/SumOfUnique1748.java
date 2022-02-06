import java.util.HashSet;
import java.util.Set;

/**
 * 1748. 唯一元素的和
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/2/6
 */
public class SumOfUnique1748 {

    public int sumOfUnique(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> singleSet = new HashSet<>();
        for (int num : nums) {
            singleSet.add(num);
            if (set.contains(num)) {
                singleSet.remove(num);
            }
            set.add(num);
        }

        return singleSet.stream().mapToInt(Integer::intValue).sum();
    }

}
