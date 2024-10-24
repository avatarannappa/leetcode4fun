/**
 * 3175. 找到连续赢 K 场比赛的第一位玩家.
 * medium
 *
 * @author avatarannappa
 * @version 2024/10/24
 */
public class FindWinningPlayer3175 {

    public int findWinningPlayer(int[] skills, int k) {
        // 规律+双指针
        int n = skills.length;
        int i = 0;
        int j = 1;
        int count = 0;
        while (j < n) {
            if (skills[i] > skills[j]) {
                count++;
            } else {
                i = j;
                count = 1;
            }
            if (count == k) {
                return i;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] skills = {4, 2, 6, 3, 9};
        int k = 2;
        // 2
        System.out.println(new FindWinningPlayer3175().findWinningPlayer(skills, k));
    }
}
