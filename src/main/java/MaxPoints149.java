import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 149. 直线上最多的点数(hard)
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 * @author avatarannappa
 * @version 1.0, 2019/10/25
 */
public class MaxPoints149 {

    public int xielv(Double[] p) {
        if (p.length == 0) {
            return 0;
        } else if (p.length < 2) {
            return 1;
        }
        int result = 0;
        int temp = 1;

        List<Double> pp = new ArrayList<>();
        for (int i = 0; i < p.length; i++) {
            if (p[i] == null) {
                result++;
            } else {
                pp.add(p[i]);
            }
        }

        pp.sort(Comparator.naturalOrder());
        for (int i = 0; i < pp.size() - 1; i++) {
            if (pp.get(i).equals(pp.get(i + 1))) {
                temp++;
            } else {
                temp = 1;
            }

            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }

    public int maxPoints(int[][] points) {
        int result = 0;
        if (points.length < 1) {
            return 0;
        } else if (points.length < 2) {
            return 1;
        } else if (points.length == 2) {
            return 2;
        }
        for (int i = 0; i < points.length - 1; i++) {
            int temp = 0;
            int same = 0;

            for (int j = i + 1; j < points.length; j++) {
                if ((points[j][0] == points[i][0]) && (points[j][1] == points[i][1])) {
                    same++;
                }
            }
            Double[] p = new Double[points.length - (1 + i) - same];
            for (int j = i + 1,pIndex = 0; j < points.length; j++) {
                if (points[j][0] == points[i][0]) {
                    if (points[j][1] == points[i][1]) {
                        continue;
                    } else {
                        p[pIndex++] = null;
                    }

                } else {
                    p[pIndex++] = (double)(points[j][1] - points[i][1]) * 1000 / (double) (points[j][0] - points[i][0]) * 1000 + 0.0;
                }

            }
            temp = xielv(p) + same;
            if (temp > result) {
                result = temp;
            }
        }
        result++;
        return result;
    }

    public static void main(String[] args) {
        MaxPoints149 o = new MaxPoints149();
        // int[][] points = {{84,250},{0,0},{1,0},{0,-70},{0,-70},{1,-1},{21,10},{42,90},{-42,-230}}; // 6
        // int[][] points = {{2,3},{3,3},{-5,3}}; //3 +0.0
        int[][] points = {{0,0},{94911151,94911150},{94911152,94911151}};
        int result = o.maxPoints(points);
        System.out.println(result);
    }
}
