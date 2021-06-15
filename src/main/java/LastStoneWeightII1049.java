/**
 * 1049. 最后一块石头的重量 II
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/11
 */
public class LastStoneWeightII1049 {
    int maxSum;
    int[] stones;
    int res = 0;

    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        this.stones = stones;
        int temp = 0;
        for (int stone : stones) {
            temp += stone;
        }
        maxSum = temp / 2;
        recursion(0, 0);
        return temp - 2 * res;
    }

    public void recursion(int index, int sum) {
        if (sum > maxSum) {
            return;
        }
        if (res == maxSum) {
            return;
        }
        if (index == stones.length) {
            if (sum > res) {
                res = sum;
            }
            return;
        }
        recursion(index + 1, sum + stones[index]);
        recursion(index + 1, sum);
    }

    public static void main(String[] args) {
        int[] stones =
                {89, 23, 100, 93, 82, 98, 91, 85, 33, 95, 72, 98, 63, 46, 17, 91, 92, 72, 77, 79, 99, 96, 55, 72, 24,
                        98, 79, 93, 88, 92};
        // 0
        System.out.println(new LastStoneWeightII1049().lastStoneWeightII(stones));
    }
}
