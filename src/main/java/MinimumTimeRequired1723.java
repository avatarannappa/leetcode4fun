/**
 * 1723. 完成所有工作的最短时间
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/9
 */
public class MinimumTimeRequired1723 {

    int[] jobs;
    int n, k;
    int res = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        this.jobs = jobs;
        n = jobs.length;
        this.k = k;
        int[] sum = new int[k];
        dfs(0, 0, sum, 0);
        return res;
    }

    void dfs(int u, int used, int[] sum, int max) {
        if (max >= res) {
            return;
        }
        if (u == n) {
            res = max;
            return;
        }
        // 优先分配给「空闲工人」
        if (used < k) {
            sum[used] = jobs[u];
            dfs(u + 1, used + 1, sum, Math.max(sum[used], max));
            sum[used] = 0;
        }
        for (int i = 0; i < used; i++) {
            sum[i] += jobs[u];
            dfs(u + 1, used, sum, Math.max(sum[i], max));
            sum[i] -= jobs[u];
        }
    }

    public static void main(String[] args) {
        int[] jobs = {1, 2, 4, 7, 8};
        int k = 2;
        System.out.println(new MinimumTimeRequired1723().minimumTimeRequired(jobs, k));
    }
}
