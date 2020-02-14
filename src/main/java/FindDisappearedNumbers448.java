import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/14
 */
public class FindDisappearedNumbers448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            temp[num - 1] = 1;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new FindDisappearedNumbers448().findDisappearedNumbers(nums));
    }
}
