import java.util.List;

/**
 * 96. 不同的二叉搜索树
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/10
 */
public class NumTrees96 {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i < n; i++) {

        }
        return 0;
    }

    public int numTreesRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += doRecursion(i, n);
        }
        return result;
    }

    public int doRecursion(int i, int n) {
        return numTreesRecursion(i - 1) * numTreesRecursion(n - i);
    }

    public static void main(String[] args) {
        NumTrees96 n = new NumTrees96();
        int param = 3;
        int num = n.numTreesRecursion(param);
        System.out.println(num);
    }
}
