/**
 * 904. 水果成篮
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/10/17
 */
public class TotalFruit904 {

    public int totalFruit(int[] fruits) {
        // 滑动窗口
        int ans = 0;

        int[] cnts = new int[fruits.length + 10];
        int bucket = 0;
        for (int i = 0, j = 0; i < fruits.length; i++) {
            cnts[fruits[i]]++;
            if (cnts[fruits[i]] == 1) {
                bucket++;
            }
            while (bucket > 2) {
                if (--cnts[fruits[j]] == 0) {
                    // 清空一类
                    bucket--;
                }
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        // 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
        // 输出：5
        // 解释：可以采摘 [1,2,1,1,2] 这五棵树。
        // int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int[] fruits = {6, 2, 1, 1, 3, 6, 6};
        // 3
        System.out.println(new TotalFruit904().totalFruitOld(fruits));
    }
}
