/**
 * 1011. 在 D 天内送达包裹的能力
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/28
 */
public class ShipWithinDays1011 {

    public int shipWithinDays(int[] weights, int D) {
        // 二分 二段性
        int max = 0;
        int sum = 0;
        for (int w : weights) {
            max = Math.max(w, max);
            sum += w;
        }
        int l = max;
        int r = sum;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(weights, mid, D)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    boolean check(int[] weights, int mid, int D) {
        int count = 0;
        for (int i = 0; i < weights.length; ) {
            int sum = 0;
            while (i < weights.length && sum + weights[i] <= mid) {
                sum += weights[i];
                i++;
            }
            count++;
        }
        return count <= D;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;
        System.out.println(new ShipWithinDays1011().shipWithinDays(weights, D));
    }

}
