import java.util.Arrays;

/**
 * 1103. 分糖果II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/11
 */
public class DistributeCandies1103 {

    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int sum = (num_people + 1) * num_people / 2;
        int times = 0;
        int left = candies;
        for (int i = 0; ; i++) {
            int temp = sum + num_people * num_people * i;
            if (left < temp) {
                times = i;
                break;
            }
            left = left - temp;
        }

        for (int i = 0; i < result.length; i++) {
            int j = i + 1;
            result[i] = num_people * times + j * (times + 1);

            if (left < result[i] && left > 0) {
                result[i] = result[i] - j + left;
                left = left - result[i];
            } else if (left >= result[i]) {
                left = left - result[i];
            } else {
                result[i] = result[i] - num_people - j;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DistributeCandies1103().distributeCandies(55, 3)));
    }
}
