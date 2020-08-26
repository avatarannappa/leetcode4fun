import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/26
 */
public class GenerateTrees95 {

    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return result;
        }
        return doRecursion(1, n);
    }

    public List<TreeNode> doRecursion(int left, int right) {
        List<TreeNode> list = new ArrayList<>();

        if (left > right) {
            list.add(null);
            return list;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = doRecursion(left, i - 1);
            List<TreeNode> rightList = doRecursion(i + 1, right);
            for (TreeNode l : leftList) {
                for (TreeNode r : rightList) {
                    TreeNode root = new TreeNode();
                    root.val = i;
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        GenerateTrees95 g = new GenerateTrees95();
        int n = 3;
        List<TreeNode> result = g.generateTrees(n);
        System.out.println(result);
    }
}
