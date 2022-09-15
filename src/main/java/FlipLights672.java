/**
 * 672. 灯泡开关 Ⅱ
 * medium
 *
 * @author avatarannappa
 * @date 2022/9/15
 */
public class FlipLights672 {

    public int flipLights(int n, int presses) {
        // 找规律
        // 周期6 -> 周期中状态不同的等4 -> 通过1、2、3可以确定4，所以看3个灯的状态；直接列举状态
        if (presses == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return presses == 1 ? 3 : 4;
        } else {
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int presses = 2;
        // 7
        System.out.println(new FlipLights672().flipLights(n, presses));
    }
}
