/**
 * 2409. 统计共同度过的日子数
 * easy
 *
 * @author chenhao138
 * @date 2023/4/17
 */
public class CountDaysTogether2409 {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] sum = new int[13];
        for (int i = 0; i < dayOfMonth.length; i++) {
            sum[i + 1] = sum[i] + dayOfMonth[i];
        }

        int[] days = new int[365];
        int m = 0;
        int d = 0;
        m = Integer.parseInt(arriveAlice.split("-")[0]) - 1;
        d = Integer.parseInt(arriveAlice.split("-")[1]) - 1;
        int startAlice = sum[m] + d;
        m = Integer.parseInt(leaveAlice.split("-")[0]) - 1;
        d = Integer.parseInt(leaveAlice.split("-")[1]) - 1;
        int endAlice = sum[m] + d;
        m = Integer.parseInt(arriveBob.split("-")[0]) - 1;
        d = Integer.parseInt(arriveBob.split("-")[1]) - 1;
        int startBob = sum[m] + d;
        m = Integer.parseInt(leaveBob.split("-")[0]) - 1;
        d = Integer.parseInt(leaveBob.split("-")[1]) - 1;
        int endBob = sum[m] + d;

        for (int i = startAlice; i <= endAlice; i++) {
            days[i] = 1;
        }

        int res = 0;
        for (int i = startBob; i <= endBob; i++) {
            if (days[i] == 1) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31";
        // 0
        System.out.println(new CountDaysTogether2409().countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }
}
