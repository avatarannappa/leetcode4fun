import java.util.Arrays;
import java.util.Comparator;

/**
 * 2611. 老鼠和奶酪
 * medium
 *
 * @author avatarannappa
 * @date 2023/6/7
 */
public class MiceAndCheese2611 {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        // 贪心+排序 O(nlogn)
        int ans = 0;
        Integer[] diff = new Integer[reward1.length];
        for (int i = 0; i < reward1.length; i++) {
            ans += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }

        Arrays.sort(diff, Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            ans += diff[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] reward1 = {1, 1, 3, 4};
        int[] reward2 = {4, 4, 1, 1};
        int k = 2;
        // 15
        System.out.println(new MiceAndCheese2611().miceAndCheese(reward1, reward2, k));
    }
}
