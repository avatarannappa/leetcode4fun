/**
 * 2511. 最多可以摧毁的敌人城堡数目
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2023/9/2
 */
public class CaptureForts2511 {

    public int captureForts(int[] forts) {
        // 简单模拟
        int ans = 0;

        int start = 0;
        int index = 0;
        for (int i = 0; i < forts.length; i++) {
            int now = forts[i];
            if (now == 0) {
                continue;
            } else if (now == -1) {
                if (start == 1) {
                    ans = Math.max(ans, i - index - 1);
                }
                start = -1;
                index = i;
            } else {
                if (start == -1) {
                    ans = Math.max(ans, i - index - 1);
                }
                start = 1;
                index = i;
            }
        }

        return ans;
    }

    public int captureFortsNew(int[] forts) {
        // 简单模拟
        int ans = 0;

        int start = 0;
        int index = 0;
        for (int i = 0; i < forts.length; i++) {
            int now = forts[i];
            if (now != 0) {
                if (start + now == 0) {
                    ans = Math.max(ans, i - index - 1);
                }
                start = now;
                index = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] forts = {1, 0, 0, -1, 0, 0, 0, 0, 1};
        System.out.println(new CaptureForts2511().captureForts(forts));
    }
}
