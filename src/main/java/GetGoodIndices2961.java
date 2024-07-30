import java.util.ArrayList;
import java.util.List;

/**
 * 2961. 双模幂运算
 * medium
 *
 * @author avatarannappa
 * @date 2024/7/30
 * @see MyPow 50.pow
 */
public class GetGoodIndices2961 {

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        // 快速幂取模 & 位运算(正确性证明)
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] v = variables[i];
            if (cal(cal(v[0], v[1], 10), v[2], v[3]) == target) {
                res.add(i);
            }
        }
        return res;
    }

    private int cal(int x, int y, int target) {
        int res = 1;

        while (y > 0) {
            if ((y & 1) != 0) {
                res = res * x % target;
            }
            x = x * x % target;
            y >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] variables = {{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}};
        int target = 2;
        // 输出：[0,2]
        System.out.println(new GetGoodIndices2961().getGoodIndices(variables, target));
    }
}
