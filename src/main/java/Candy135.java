/**
 * 135. 分发糖果.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/6
 */
public class Candy135 {

    public int candy(int[] ratings) {
        int result = 0;
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int[] right = new int[n];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        for (int i = 0; i < right.length; i++) {
            result += Math.max(left[i], right[i]) + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] rating = {1, 2, 2};
        System.out.println(new Candy135().candy(rating));
    }
}
