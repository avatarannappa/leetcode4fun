/**
 * 2582. 递枕头
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2023/09/26
 */
public class PassThePillow2582 {

    public int passThePillow(int n, int time) {
        int cnt = time / (n - 1);
        int left = time % (n - 1);
        return cnt % 2 == 0 ? 1 + left : n - 1;
    }

    public static void main(String[] args) {
        int n = 4;
        int time = 5;
        System.out.println(new PassThePillow2582().passThePillow(n, time));
    }
}
