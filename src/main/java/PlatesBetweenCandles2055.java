import java.util.Arrays;

/**
 * 2055. 蜡烛之间的盘子.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/3/8
 */
public class PlatesBetweenCandles2055 {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        // 前缀和+区间映射，query[0]的右边最近candle，query[1]的左边最近candle位置映射
        int len = s.length();
        int[] sum = new int[len];
        int[] leftCandy = new int[len];
        int[] rightCandy = new int[len];

        int l = -1;
        for (int i = 0; i < len; i++) {
            if (i >= 1) {
                sum[i] = sum[i - 1];
            }
            if (s.charAt(i) == '|') {
                l = i;
            } else {
                sum[i]++;
            }
            leftCandy[i] = l;
        }
        
        int r = len;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            rightCandy[i] = r;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (leftCandy[query[1]] <= rightCandy[query[0]]) {
                res[i] = 0;
            } else {
                res[i] = sum[leftCandy[query[1]]] - sum[rightCandy[query[0]]];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        // [9,0,0,0,0]
        System.out.println(Arrays.toString(new PlatesBetweenCandles2055().platesBetweenCandles(s, queries)));
    }
}
