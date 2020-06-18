import java.util.TreeSet;

/**
 * 414. 第三大的数.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/18
 */
public class ThirdMax414 {

    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() < 3 ? set.last() : set.first();
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 1};
        System.out.println(new ThirdMax414().thirdMax(nums));
    }
}
