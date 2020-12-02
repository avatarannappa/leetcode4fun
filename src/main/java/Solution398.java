import java.util.Random;

/**
 * 398. 随机数索引
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/2
 */
public class Solution398 {

    private int[] head;

    private Random random = new Random();

    public Solution398(int[] nums) {
        head = nums;
    }

    public int pick(int target) {
        int targetIndex = 0;
        int count = 1;
        for (int i = 0; i < head.length; i++) {
            if (head[i] == target) {
                if (random.nextInt(count) == 0) {
                    targetIndex = i;
                }
                count++;
            }
        }
        return targetIndex;
    }
}
