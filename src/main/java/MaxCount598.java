/**
 * 598. 范围求和II.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/4
 */
public class MaxCount598 {

    public int maxCount(int m, int n, int[][] ops) {
        int minM = m;
        int minN = n;
        for (int[] op : ops) {
            minM = Math.min(minM, op[0]);
            minN = Math.min(minN, op[1]);
        }
        return minM * minN;
    }

}
