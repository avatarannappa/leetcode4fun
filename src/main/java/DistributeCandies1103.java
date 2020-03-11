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

        int n = 0;
        if (times > 0) {
            n = (times - 1) * times / 2;
        }
        for (int i = 0; i < result.length; i++) {
            int j = i + 1;
            result[i] = num_people * n + j * times;
            int next = num_people * times + j;
            if (left < next && left > 0) {
                result[i] = result[i] + left;
                left = left - result[i];
            } else if (left >= next) {
                result[i] += next;
                left = left - next;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DistributeCandies1103().distributeCandies(8899, 5)));
    }
}
