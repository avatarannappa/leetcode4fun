/**
 * 961. 重复 N 次的元素.
 * easy.
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/31
 */
public class RepeatedNTimes961 {

    public int repeatedNTimes(int[] A) {
        int[] array = new int[10000];
        for (int i = 0; i < A.length; i++) {
            if (array[A[i]] != 0) {
                return A[i];
            }
            array[A[i]] = 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {5, 1, 5, 2, 5, 3, 5, 4};
        System.out.println(new RepeatedNTimes961().repeatedNTimes(A));
    }

}
