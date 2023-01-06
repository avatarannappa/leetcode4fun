import java.util.Arrays;

/**
 * 2180. 统计各位数字之和为偶数的整数个数
 * easy
 *
 * @author avatarannappa
 * @date 2023/1/6
 */
public class CountEven2180 {

    public int countEven(int num) {
        int res = 0;

        for (int i = 1; i <= num; i++) {
            int sum = Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();
            if (sum % 2 == 0) {
                res++;
            }
        }

        return res;
    }

    public int countEvenNew(int num) {
        // 数学规律
        int t = 0;
        for (int j = num; j > 0; j /= 10) {
            t += j % 10;
        }
        return t % 2 == 1 ? --num / 2 : num / 2;
    }

    public static void main(String[] args) {
        int num = 30;
        // 14
        System.out.println(new CountEven2180().countEven(num));
    }
}
