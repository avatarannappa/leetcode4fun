import java.util.Arrays;

/**
 * 1774. 最接近目标价格的甜点成本.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/12/4
 */
public class ClosestCost1774 {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        // 三状态压缩
        int m = baseCosts.length;
        int n = toppingCosts.length;
        int[] pow = new int[n + 1];
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = pow[i - 1] * 3;
        }

        int ans = -1;
        int min = (int) 1e10;
        for (int i = 0; i < pow[n]; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += i / pow[j] % 3 * toppingCosts[j];
            }
            for (int j = 0; j < m; j++) {
                int price = sum + baseCosts[j];
                int gap = Math.abs(target - price);
                if (min > gap || (min == gap && ans > price)) {
                    ans = price;
                    min = gap;
                }
            }
        }
        return ans;
    }

    int ans = 0;
    int min = Integer.MAX_VALUE;
    int[] toppingCosts;
    int target;

    public int closestCost1(int[] baseCosts, int[] toppingCosts, int target) {
        // 回溯
        this.toppingCosts = toppingCosts;
        this.target = target;
        ans = Arrays.stream(baseCosts).min().getAsInt();

        for (int baseCost : baseCosts) {
            backTracking(0, baseCost);
        }

        return ans;
    }

    public void backTracking(int index, int cost) {
        int nowGap = cost - target;
        int absNowGap = Math.abs(nowGap);
        if (min < nowGap) {
            return;
        } else if (min > absNowGap) {
            ans = cost;
            min = absNowGap;
        } else if (min == absNowGap) {
            ans = Math.min(ans, cost);
        }
        if (index == toppingCosts.length) {
            return;
        }
        backTracking(index + 1, cost);
        backTracking(index + 1, cost + toppingCosts[index]);
        backTracking(index + 1, cost + toppingCosts[index] * 2);
    }

    public static void main(String[] args) {
        int[] baseCosts = {1, 7};
        int[] toppingCosts = {3, 4};
        int target = 10;
        // 10
        System.out.println(new ClosestCost1774().closestCost(baseCosts, toppingCosts, target));
    }
}
