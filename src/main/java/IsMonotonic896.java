/**
 * 896. 单调数列.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/13
 */
public class IsMonotonic896 {

    public boolean isMonotonic(int[] A) {
        int result = 0;
        if (A.length == 1) {
            return true;
        }
        for (int i = 1; i < A.length; i++) {
            int temp = A[i] - A[i - 1];
            if (temp < 0 && result > 0) {
                return false;
            } else if (temp > 0 && result < 0) {
                return false;
            }
            if (temp != 0) {
                result = temp < 0 ? -1 : 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {11, 11, 9, 4, 3, 3, 3, 1, -1, -1, 3, 3, 3, 5, 5, 5};
        System.out.println(new IsMonotonic896().isMonotonic(A));
    }
}
