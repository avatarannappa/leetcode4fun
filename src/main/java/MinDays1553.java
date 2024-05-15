import java.util.HashMap;
import java.util.Map;

/**
 * 1553.吃掉N个橘子的最少天数
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2024/5/12
 */
public class MinDays1553 {

  Map<Integer, Integer> mem = new HashMap<>();

  public int minDays(int n) {
    // 10^9 一次循环O(n)都不行
    // 记忆化搜索
    if (n <= 1) {
      return n;
    }
    if (mem.containsKey(n)) {
      return mem.get(n);
    }
    int res = Math.min(minDays(n / 2) + n % 2, minDays(n / 3) + n % 3) + 1;
    mem.put(n, res);
    return res;
  }

  public static void main(String[] args) {
    int n = 10;
    // 4
    System.out.println(new MinDays1553().minDays(n));
  }
}
