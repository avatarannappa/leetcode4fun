import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/11
 */
public class GenerateTrees95 {

    public static void main(String[] args) {
        GenerateTrees95 g = new GenerateTrees95();
        int n = 3;
        List<TreeNode> result = g.generateTrees(n);
        System.out.println(result);
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0) {
            return result;
        } else if (n == 1) {
            result.add(new TreeNode(1));
            return result;
        }
        for (int i = 2; i <= n; i++) {
            List<TreeNode> treeNode = doRecursion(i, n);
            result.addAll(treeNode);
        }
        return result;
    }

    public List<TreeNode> doRecursion(int root, int n) {
        List<TreeNode> treeNode = new ArrayList<>();

        return treeNode;
    }
}
