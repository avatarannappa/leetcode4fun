/**
 * 1217. 玩筹码
 * easy
 *
 * @author avatarannappa
 * @date 2022/7/8
 */
public class MinCostToMoveChips1217 {

    public int minCostToMoveChips(int[] position) {
        // 脑筋急转弯，注意移动偶数位，cost=0；
        // 【1， 1000000】可以移动一次奇数，多次偶数，所以cost=1
        int odd = 0;
        int even = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        int[] position = {2, 2, 2, 3, 3};
        // 2
        System.out.println(new MinCostToMoveChips1217().minCostToMoveChips(position));
    }
}
