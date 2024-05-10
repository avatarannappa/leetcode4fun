/**
 * 2960. 统计已测试设备
 * easy
 *
 * @author avatarannappa
 * @date 2024/5/10
 */
public class CountTestedDevices2960 {

    public int countTestedDevices(int[] batteryPercentages) {
        // 简单模拟
        int res = 0;

        for (int i = 0; i < batteryPercentages.length; i++) {
            int now = batteryPercentages[i];
            if (now - res > 0) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] batteryPercentages = {1, 1, 2, 1, 3};
        // 3
        System.out.println(new CountTestedDevices2960().countTestedDevices(batteryPercentages));
    }
}
