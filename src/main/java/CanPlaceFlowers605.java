/**
 * 605. 种花问题.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/9
 */
public class CanPlaceFlowers605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 贪心
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) &&
                (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }

}
