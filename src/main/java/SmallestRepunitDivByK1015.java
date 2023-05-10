import java.util.HashSet;
import java.util.Set;

/**
 * 1015. 可被 K 整除的最小整数
 * medium
 *
 * @author avatarannappa
 * @date 2023/5/10
 */
public class SmallestRepunitDivByK1015 {

    public int smallestRepunitDivByK(int k) {
        // 数学：模运算，哈希表
        // todo O(k)
        Set<Integer> set = new HashSet<>();

        int x = 0;
        int ans = 0;
        while (true) {
            ans++;
            set.add(x);
            int newX = 10 * x + 1;
            x = newX % k;
            if (x == 0) {
                break;
            } else if (set.contains(x)) {
                return -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int k = 3;
        // 3, 111
        System.out.println(new SmallestRepunitDivByK1015().smallestRepunitDivByK(k));
    }
}
