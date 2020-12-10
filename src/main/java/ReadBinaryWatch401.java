import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 401. 二进制手表
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/10
 */
public class ReadBinaryWatch401 {

    Set<String> result = new HashSet<>();
    int[] hour = {1, 2, 4, 8};
    int[] min = {1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int num) {
        // 回溯
        boolean[] mask = new boolean[11];
        backTracking(new int[2], mask, num);
        // backTracking2(0, 0, num, 0);
        System.out.println(result.size());
        return new LinkedList<>(result);
    }

    public void backTracking(int[] time, boolean[] mask, int num) {
        if (num == 0) {
            if (time[1] < 10) {
                result.add(time[0] + ":0" + time[1]);
            } else {
                result.add(time[0] + ":" + time[1]);
            }
            return;
        }
        for (int i = 1; i < 11; i++) {
            if (!mask[i]) {
                if (i < 7) {
                    int m = min[i - 1];
                    if (time[1] + m > 59) {
                        return;
                    } else {
                        time[1] = time[1] + m;
                        mask[i] = true;
                        backTracking(time, mask, num - 1);
                        mask[i] = false;
                        time[1] = time[1] - m;
                    }
                } else {
                    int h = hour[i - 7];
                    if (time[0] + h > 11) {
                        return;
                    } else {
                        time[0] = time[0] + h;
                        mask[i] = true;
                        backTracking(time, mask, num - 1);
                        mask[i] = false;
                        time[0] = time[0] - h;
                    }
                }
            }
        }
    }

    public void backTracking2(int h, int m, int num, int index) {
        // 有点问题，不想改了
        if (num == 0) {
            String time = m < 10 ? h + ":0" + m : h + ":" + m;
            result.add(time);
            return;
        }
        for (int i = index; i < 10; i++) {
            if (i < 6) {
                int mm = min[i];
                if (mm + m > 59) {
                    return;
                } else {
                    backTracking2(h, m + mm, num - 1, i + 1);
                }
            } else {
                int hh = hour[i - 6];
                if (hh + h > 11) {
                    return;
                } else {
                    backTracking2(h + hh, m, num - 1, i + 1);
                }
            }
        }
    }

    public List<String> readBinaryWatchNew(int num) {
        // 常数时间复杂度 24 * 60
        // 直接遍历  0:00 -> 12:00   每个时间有多少1
        List<String> result = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (count1(i) + count1(j) == num) {
                    result.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return result;
    }

    //计算二进制中1的个数
    int count1(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        // 输入: n = 1
        //返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
        int n = 4;
        System.out.println(new ReadBinaryWatch401().readBinaryWatch(n));
    }
}
