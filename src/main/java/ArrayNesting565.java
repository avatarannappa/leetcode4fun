import java.util.HashSet;
import java.util.Set;

/**
 * 565. 数组嵌套.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/7/17
 */
public class ArrayNesting565 {


    public int arrayNesting(int[] nums) {
        // https://www.bilibili.com/video/BV17W4y1S7WR?spm_id_from=333.337.search-card.all.click&vd_source=d5fb7ef1e4c0a2391afea35f9324963a
        int max = 0;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            if (set.contains(i)) {
                continue;
            }

            int index = i;
            int len = 0;
            while (!set.contains(index)) {
                set.add(index);
                len++;
                index = nums[index];
            }
            max = Math.max(max, len);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        // 4
        System.out.println(new ArrayNesting565().arrayNesting(nums));
    }
}
