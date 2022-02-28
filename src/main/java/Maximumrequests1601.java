import java.util.Arrays;

/**
 * 1601. 最多可达成的换楼请求数目.
 * hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/2/28
 */
public class Maximumrequests1601 {

    public int maximumRequests(int n, int[][] requests) {
        // n <= 20, m<=16。穷举+位运算
        int[] delta = new int[n];
        int ans = 0, m = requests.length;
        for (int mask = 0; mask < (1 << m); ++mask) {
            int cnt = Integer.bitCount(mask);
            if (cnt <= ans) {
                continue;
            }
            Arrays.fill(delta, 0);
            for (int i = 0; i < m; ++i) {
                if ((mask & (1 << i)) != 0) {
                    ++delta[requests[i][0]];
                    --delta[requests[i][1]];
                }
            }
            boolean flag = true;
            for (int x : delta) {
                if (x != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = cnt;
            }
        }
        return ans;
    }

    int cnt(int s) {
        // 通过lowBit算法：lowBit = i & -i 或 lowBit = x & (x^(x-1))，循环计算二进制1个数。可用Integer.bitCount(int s)替换
        // 会慢一点
        int ans = 0;
        for (int i = s; i > 0; i -= (i & -i)) {
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] requests = {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}};
        // 5
        System.out.println(new Maximumrequests1601().maximumRequests(n, requests));
    }

}
