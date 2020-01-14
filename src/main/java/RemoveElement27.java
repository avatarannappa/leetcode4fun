import java.util.Arrays;

/**
 * 27. 移除元素
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/6
 */
public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveElement27 removeElement27 = new RemoveElement27();
        int[] nums = {3, 2, 2, 3};
        int val = 2;
        int c = removeElement27.removeElement(nums, val);
        System.out.println(c);
        System.out.println(Arrays.toString(nums));
    }
}
