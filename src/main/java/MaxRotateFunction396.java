import java.util.Arrays;

/**
 * 396. 旋转函数
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/21
 */
public class MaxRotateFunction396 {

    public int maxRotateFunction(int[] A) {
        // 一维数组DP
        // n = A.length
        // f(0) = 0*A[0] + 1*A[1] + ... + (n-1)*A(n-1)
        // m = A[0] + A[1] + ... + A[n-1]
        // f(i) - f(i-1) = m - n * A[n-i]
        if (A == null || A.length < 1) {
            return 0;
        }
        int[] sumArray = new int[A.length];
        int m = 0;
        for (int i = 0; i < A.length; i++) {
            sumArray[0] += A[i] * i;
            m += A[i];
        }
        for (int i = 1; i < A.length; i++) {
            sumArray[i] = sumArray[i - 1] + m - A.length * A[A.length - i];
        }
        System.out.println(Arrays.toString(sumArray));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, sumArray[i]);
        }
        return max;
    }

    public int maxRotateFunctionOld(int[] A) {
        // 时间复杂度O(n ^ 2)
        if (A == null || A.length < 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int temp = 0;
            for (int j = 0; j < A.length; j++) {
                temp += A[(j + i) % A.length] * j;
            }
            max = Math.max(temp, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6};
        System.out.println(new MaxRotateFunction396().maxRotateFunction(A));
    }
}
