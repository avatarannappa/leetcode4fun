public class KthGrammar779 {
/**
 * 779. 第K个语法符号
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/20
 */
    public int kthGrammar(int n, int k) {
        if (k == 1) {
            return 0;
        }
        boolean left = k % 2 == 1;
        int parent = kthGrammar(n - 1, (k + 1) / 2);
        return left ? parent : parent ^ 1;
    }
    
    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        // 0110
        // 1
        System.out.println(new KthGrammar779().kthGrammar(n, k));
    }
}
