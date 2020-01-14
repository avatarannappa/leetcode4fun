/**
 * 42. 接雨水
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/20
 */
public class Trap42 {

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int water = 0;
        int l = 0, r = height.length - 1;
        int lm = height[l], rm = height[r];
        int min = Math.min(lm, rm);
        boolean sign = lm < rm; // true left, false right;

        while (l < r) {
            if (sign) {
                if (height[l] > lm) {
                    lm = height[l];
                    min = Math.min(lm, rm);
                } else {
                    water += min - height[l];
                }
            } else {
                if (height[r] > rm) {
                    rm = height[r];
                    min = Math.min(lm, rm);
                } else {
                    water += min - height[r];
                }
            }

            if (lm < rm) {
                l++;
                sign = true;
            } else {
                r--;
                sign = false;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Trap42().trap(h));
    }

}
