/**
 * 1450. 在既定时间做作业的学生人数
 * easy
 *
 * @author avatarannappa
 * @date 2022/8/19
 */
public class BusyStudent1450 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        // O(n)
        // 排序 + 二分 O(nlogn)
        int n = startTime.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                ans++;
            }
        }
        return ans;
    }

    public int busyStudentNew(int[] startTime, int[] endTime, int queryTime) {
        // 差分。区间修改 + 单点查询
        int[] arr = new int[10001];
        for (int i = 0; i < startTime.length; i++) {
            arr[startTime[i]]++;
            arr[endTime[i] + 1]--;
        }
        for (int i = 1; i <= queryTime; i++) {
            arr[i] += arr[i - 1];
        }
        return arr[queryTime];
    }

    public static void main(String[] args) {
        int[] startTime = {4};
        int[] endTime = {4};
        int queryTime = 4;
        // 1
        System.out.println(new BusyStudent1450().busyStudentNew(startTime, endTime, queryTime));
    }
}
