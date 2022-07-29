/**
 * 593. 有效的正方形
 * medium
 *
 * @author avatarannappa
 * @date 2022/7/29
 */
public class ValidSquare593 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 几何，勾股定理应用
        return cal(p1, p2, p3) && cal(p2, p3, p4) && cal(p3, p4, p1);
    }

    public boolean cal(int[] p1, int[] p2, int[] p3) {
        int l1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int l2 = (p3[0] - p2[0]) * (p3[0] - p2[0]) + (p3[1] - p2[1]) * (p3[1] - p2[1]);
        int l3 = (p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1]);
        if (l1 != l2 && l2 != l3 && l1 != l3) {
            return false;
        }
        if (l1 == 0 || l2 == 0 || l3 == 0) {
            return false;
        }
        return (l1 > l2 && l2 == l3 && l1 == l2 + l3)
            || (l2 > l1 && l1 == l3 && l2 == l1 + l3)
            || (l3 > l1 && l1 == l2 && l3 == l1 + l2);
    }

    public static void main(String[] args) {
        int[] p1 = {1, 0}, p2 = {-1, 0}, p3 = {0, 1}, p4 = {0, -1};
        System.out.println(new ValidSquare593().validSquare(p1, p2, p3, p4));
    }
}
