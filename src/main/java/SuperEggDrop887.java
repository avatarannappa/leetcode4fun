/**
 * 887. 鸡蛋掉落.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/29
 */
public class SuperEggDrop887 {

    int calcF(int K, int T) {
        if (T == 1 || K == 1) {
            return T + 1;
        }
        return calcF(K - 1, T - 1) + calcF(K, T - 1);
    }

    int superEggDrop(int K, int N) {
        int T = 1;
        while (calcF(K, T) < N + 1) {
            T++;
        }
        return T;
    }

    public static void main(String[] args) {
        int K = 2;
        int N = 100;
        System.out.println(new SuperEggDrop887().superEggDrop(K, N));
    }
}
