/**
 * 2483. 商店的最少代价.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2025/12/26
 */
public class BestClosingTime2483 {
    public int bestClosingTime(String customers) {
        // 前缀后缀分解
        int len = customers.length();
        int[] openCost = new int[len + 1];
        int[] closeCost = new int[len + 1];
        for (int i = 0; i < len; i++) {
            char c = customers.charAt(i);
            if (c == 'N') {
                openCost[i + 1] = openCost[i] + 1;
            } else {
                openCost[i + 1] = openCost[i];
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            char c = customers.charAt(i);
            if (c == 'N') {
                closeCost[i] = closeCost[i + 1];
            } else {
                closeCost[i] = closeCost[i + 1] + 1;
            }
        }

        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len + 1; i++) {
            int cost = openCost[i] + closeCost[i];
            if (cost < min) {
                min = cost;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String customers = "YYNY";
        // 2
        System.out.println(new BestClosingTime2483().bestClosingTime(customers));
    }
}
