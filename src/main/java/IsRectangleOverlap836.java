/**
 * 836. 矩阵重叠
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/18
 */
public class IsRectangleOverlap836 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean x = !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0]);
        boolean y = !(rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
        return x && y;
    }

    public static void main(String[] args) {
        int[] rec1 = {0, 0, 2, 2};
        int[] rec2 = {1, 1, 3, 3};
        System.out.println(new IsRectangleOverlap836().isRectangleOverlap(rec1, rec2));
    }
}
