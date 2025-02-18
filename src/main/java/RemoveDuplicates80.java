import java.util.Arrays;

/**
 * 80. 删除排序数组中的重复项 II.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/2
 */
public class RemoveDuplicates80 {

    public int removeDuplicatesNew(int[] nums) {
        // 模拟，新实现
        int i = 1;
        int cnt = 1;
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] == nums[j-1]) {
                cnt++;
                if (cnt <= 2) {
                    nums[i++] = nums[j];
                }
            } else {
                nums[i++] = nums[j];
                cnt = 1;
            }
        }
        return i;
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = nums[0];
        int count = 1;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == pre) {
                count++;
                if (count <= 2) {
                    nums[index] = num;
                    index++;
                }
            } else {
                pre = num;
                count = 1;
                nums[index] = num;
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new RemoveDuplicates80().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
