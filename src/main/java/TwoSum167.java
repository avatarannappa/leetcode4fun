import java.util.Arrays;

/**
 * 167. 两数之和II - 输入有序数组.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/12
 */
public class TwoSum167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > target) {
                break;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (sum == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                } else if (sum > target) {
                    break;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new TwoSum167().twoSum(numbers, target)));
    }
}
