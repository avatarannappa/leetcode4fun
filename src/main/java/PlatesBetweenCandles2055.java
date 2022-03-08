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
        int n = s.length();
        int[] array = new int[n];
        int preCandleIndex = -1;
        // 前缀和
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '|') {
                if (preCandleIndex != -1) {
                    array[i] = array[i - 1] + i - preCandleIndex - 1;
                    preCandleIndex = i;
                    continue;
                }
                preCandleIndex = i;
            }
            if (i > 0) {
                array[i] = array[i - 1];
            }
        }
        // 记录candle位置
        int[] lArray = new int[n];
        int[] rArray = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                lArray[i] = i;
            } else {
                lArray[i] = i == 0 ? 0 : lArray[i-1];
            }
            
            int r = n - i - 1;
            if (s.charAt(r) == '|') {
                rArray[r] = r;
            } else {
                rArray[r] = r == n - 1 ? n - 1 : rArray[r + 1];
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            // query[0]的右边最近candle，query[1]的左边最近candle位置映射。用循环超时，二分貌似可以
            l = rArray[l];
            r = lArray[r];
            if (l < r) {
                ans[i] = array[r] - array[l];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        // [9,0,0,0,0]
        System.out.println(Arrays.toString(new PlatesBetweenCandles2055().platesBetweenCandles(s, queries)));
    }
}
