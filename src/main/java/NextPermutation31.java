import java.util.Arrays;

/**
 * 31. 下一个排列.
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/7
 */
public class NextPermutation31 {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int replaceIndex = -1;
        int index = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (j > replaceIndex) {
                        replaceIndex = j;
                        index = i;
                    }
                }
            }
        }
        if (replaceIndex == -1) {
            replaceIndex = 0;
        }
        swap(nums, index, replaceIndex);
    }

    public void swap(int[] nums, int i, int j) {
        int[] temp = new int[nums.length - j - 1];
        int x = nums[i];
        nums[i] = nums[j];
        nums[j] = x;
        for (int t = j + 1; t < nums.length; t++) {
            temp[t - j - 1] = nums[t];
        }
        Arrays.sort(temp);
        for (int t = j + 1; t < nums.length; t++) {
            nums[t] = temp[t - j - 1];
        }
    }

    public static void main(String[] args) {
        NextPermutation31 nextPermutation31 = new NextPermutation31();
        int[] nums = {4, 2, 0, 2, 3, 2, 0};
        // int[] nums = {1,3,2};
        // int[] nums = {2, 3, 1};
        nextPermutation31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
