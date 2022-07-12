/**
 * 1252. 奇数值单元格的数目
 * easy
 *
 * @author avatarannappa
 * @date 2022/7/12
 */
public class OddCells1252 {

    public int oddCells(int m, int n, int[][] indices) {
        // 简单模拟，55%
        int[][] matrix = new int[m][n];
        for (int[] arr : indices) {
            for (int i = 0; i < m; i++) {
                matrix[i][arr[1]]++;
            }

            for (int j = 0; j < n; j++) {
                matrix[arr[0]][j]++;
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public int oddCellsNew(int m, int n, int[][] indices) {
        // 100% O(m + n + l)
        // 记录奇数行，奇数列。根据乘法原理 result = 奇数行 * (n - 奇数列) + 奇数列 * (m - 奇数行)
        int[] mm = new int[m];
        int[] nn = new int[n];
        for (int[] arr : indices) {
            mm[arr[0]] += 1;
            nn[arr[1]] += 1;
        }
        int mOdd = 0;
        int nOdd = 0;
        for (int i : mm) {
            if (i % 2 == 1) {
                mOdd++;
            }
        }
        for (int j : nn) {
            if (j % 2 == 1) {
                nOdd++;
            }
        }
        return mOdd * (n - nOdd) + nOdd * (m - mOdd);
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int[][] indices = {{0, 1}, {1, 1}};
        /**
         * {0,0,0} -> {1,2,1} -> {1,3,1}
         * {0,0,0} -> {0,1,0} -> {1,3,1}
         */
        // 6
        System.out.println(new OddCells1252().oddCells(m, n, indices));
    }
}
