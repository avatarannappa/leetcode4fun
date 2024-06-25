import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个由0-9之间的数字组成的数组A，不一定包含全部0-9的数字。求不大于给定整数n且每位数字都在数组A中的最大数字
 * ByteDance
 *
 * @author avatarnnappa
 * @date 2024/6/21
 */
public class Test222 {

    private Integer[] arr;
    private int n;
    private int len;
    private int ans = 0;

    public int fun(Integer[] arr, int n) {
        this.arr = arr;
        this.n = n;
        String nstr = String.valueOf(n);
        this.len = nstr.length();
        Arrays.sort(this.arr, Comparator.reverseOrder());

        backTracing(0, 0);
        // 退位
        if (ans == 0) {
            for (int k = 0; k < arr.length; k++) {
                backTracing(1, 0);
                if (ans > 0) {
                    break;
                }
            }
        }
        return ans;
    }

    public void backTracing(int i, int num) {
        if (i == len) {
            if (num < n) {
                ans = num;
            }
            return;
        }
        for (int k = 0; k < arr.length; k++) {
            backTracing(i + 1, num * 10 + arr[k]);
            if (ans > 0) {
                return;
            }
        }

    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 5, 6, 8};
        int n = 7777;
        System.out.println(new Test222().fun(arr, n));
    }

}
