import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 519. 随机翻转矩阵.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/29
 */
public class Solution519 {


    int m;
    int n;
    static Set<Integer> set = new HashSet<>();
    Random random;

    public Solution519(int m, int n) {
        this.m = m;
        this.n = n;
        random = new Random();
    }

    public int[] flip() {
        int i = random.nextInt(m);
        int j = random.nextInt(n);
        int x = i * 10000 + j;
        while (set.contains(x)) {
            i = random.nextInt(m);
            j = random.nextInt(n);
            x = i * 10000 + j;
        }
        set.add(x);
        return new int[]{i, j};
    }

    public void reset() {
        set.clear();
    }

    public static void main(String[] args) {
        Solution519 s = new Solution519(5,2);
        while (set.size() < 10) {
            System.out.println(Arrays.toString(s.flip()));
        }
    }
}
