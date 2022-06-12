/**
 * 1037. 有效的回旋镖
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/6/10
 */
public class IsBoomerang1037 {

    public boolean isBoomerang(int[][] points) {
        // 向量叉乘。两个向量相乘的运算公式：A×B =(a1,a2)×(b1,b2) =a1b2-a2b1，性质：两个非零向量a和b平行，当且仅当a乘b等于0。
        // 下面斜率方法，为了不考虑浮点数和被除数0的情况，也可以直接推导出来v1[0] * v2[1] != v1[1] * v2[0]
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][0] - points[0][0]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }

    public boolean isBoomerangOld(int[][] points) {
        // 斜率，corner case太多
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    return false;
                }
            }
        }
        if (points[0][0] == points[1][0] && points[1][0] == points[2][0]) {
            return false;
        }
        if (points[0][1] == points[1][1] && points[1][1] == points[2][1]) {
            return false;
        }
        int a1 = points[0][0] - points[1][0];
        int b1 = points[0][1] - points[1][1];

        int a2 = points[1][0] - points[2][0];
        int b2 = points[1][1] - points[2][1];
        if (a1 == 0 || b1 == 0 || a2 == 0 || b2 == 0) {
            return true;
        }


        return ((double) a1 / b1) != ((double) a2 / b2);
    }

    public static void main(String[] args) {
        int[][] points = {{2, 0}, {1, 2}, {0, 0}};
        System.out.println(new IsBoomerang1037().isBoomerang(points));
    }
}
