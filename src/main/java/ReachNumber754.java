/**
 * 754. 到达终点数字
 * medium
 *
 * @author avatarannappa
 * @date 2022/11/4
 */
public class ReachNumber754 {

    public int reachNumber(int target) {
        // 数学规律
        target = Math.abs(target);
        int s = 0;
        int i = 0;
        while (s < target) {
            s += ++i;
        }
        return (s - target) % 2 == 0 ? i : i % 2 == 0 ? i + 1 : i + 2;
    }

    public static void main(String[] args) {
        int target = 2;
        // 3
        // 1 0 : 1
        // 2 1 : -1
        // 3 -1 : 2
        System.out.println(new ReachNumber754().reachNumber(target));
    }
}
