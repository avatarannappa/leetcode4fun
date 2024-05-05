import java.util.*;

/**
 * 1652. 拆炸弹
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2024/5/5
 */
public class Decrypt1652 {

  public int[] decrypt(int[] code, int k) {
    // 前缀和
    int n = code.length;
    int[] res = new int[n];
    if (k == 0) return res;
    int[] pre = new int[n+1];
    for (int i = 0; i < n; i++) {
      pre[i + 1] += pre[i] + code[i];
    }
    int l1 = 0, r1 = 0;
    int l2 = 0, r2 = 0;
    for (int i = 0; i < n; i++) {
     if (k > 0) {
       l1 = i;
       r1 = (i + k) % n;
       if (r1 < l1) {
         r2 = r1;
         l2 = -1;
         r1 = n - 1;
       }

     } else {
       r1 = (i - 1 + n) % n;
       l1 = (i - 1 + k + n) % n;
       if (r1 < l1) {
         l2 = l1;
         l1 = -1;
         r2 = n - 1;
       }
     }
     int num = pre[r2 + 1] - pre[l2 + 1] + pre[r1 + 1] - pre[l1 + 1];
     res[i] = num;
    }
    return res;
  }

  public static void main(String[] args) {
    // int[] code = {5, 7, 1, 4};
    // int k = 3;
    // 12,10,16,13
    int[] code = {2,4,9,3};
    int k = -2;
    // 12,5,6,13
    System.out.println(Arrays.toString(new Decrypt1652().decrypt(code, k)));
  }
}
