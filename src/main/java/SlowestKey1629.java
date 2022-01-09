/**
 * 1629. 按键持续时间最长的键.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/1/9
 */
public class SlowestKey1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        char ans = keysPressed.charAt(0);
        int time = releaseTimes[0];
        for (int i = 1; i < n; i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            if (duration > time) {
                ans = keysPressed.charAt(i);
                time = duration;
            } else if (duration == time) {
                ans = ans > keysPressed.charAt(i) ? ans : keysPressed.charAt(i);
                time = duration;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] releaseTimes = {12, 23, 36, 46, 62};
        String keysPressed = "spuda";
        System.out.println(new SlowestKey1629().slowestKey(releaseTimes, keysPressed));
    }
}
