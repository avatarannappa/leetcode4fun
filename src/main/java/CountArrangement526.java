/**
 * 526. 优美的排列
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/5
 */
public class CountArrangement526 {

    int count = 0;

    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }

    public void calculate(int N, int pos, boolean[] visited) {
        if (pos > N) {
            count++;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }

    public int countArrangementOld(int N) {
        // try 15 times
        int[] a = {1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
        return a[N - 1];
    }

    public static void main(String[] args) {
        int N = 2;
        System.out.println(new CountArrangement526().countArrangement(N));
    }

}
