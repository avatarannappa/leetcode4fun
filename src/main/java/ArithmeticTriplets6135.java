/**
 * 6136. 算术三元组的数目
 * 2022.08.07 周赛
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/7
 */
public class ArithmeticTriplets6135 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int two = nums[i] + diff;
            int three = two + diff;
            boolean sign = true;
            for (int num : nums) {
                if (sign) {
                    if (two == num) {
                        sign = false;
                    } else if (num > two) {
                        break;
                    }
                } else {
                    if (three == num) {
                        count++;
                        break;
                    } else if (num > three) {
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        System.out.println(new ArithmeticTriplets6135().arithmeticTriplets(nums, diff));
    }
}
