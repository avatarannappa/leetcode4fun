import java.util.Arrays;

/**
 * 2578. 最小和分割
 * easy
 *
 * @author avatarannappa
 * @date 2023/10/9
 */
public class SplitNum2578 {

    public int splitNum(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i] - '0';
            if (i % 2 == 0) {
                a = a * 10 + t;
            } else {
                b = b * 10 + t;
            }
        }
        return a + b;
    }

    public static void main(String[] args) {
        int num = 4325;
        // 59
        System.out.println(new SplitNum2578().splitNum(num));
    }
}
