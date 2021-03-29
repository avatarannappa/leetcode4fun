import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/29
 */
public class LowestCommonAncestorOffer68 {
    int pValue;
    int qValue;
    List<TreeNode> pAncestors = new LinkedList<>();
    List<TreeNode> qAncestors = new LinkedList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 存储父节点
        pValue = p.val;
        qValue = q.val;
        recursion(new LinkedList<>(), root);
        int limit = Math.min(pAncestors.size(), qAncestors.size());
        for (int i = 0; i < limit; i++) {
            if (pAncestors.get(i).val != qAncestors.get(i).val) {
                return pAncestors.get(i - 1);
            }
        }
        return pAncestors.get(limit - 1);
    }

    public void recursion(Deque<TreeNode> ancestors, TreeNode root) {
        if (root == null) {
            return;
        }
        ancestors.add(root);
        if (root.val == pValue) {
            pAncestors.addAll(ancestors);
        } else if (root.val == qValue) {
            qAncestors.addAll(ancestors);
        }
        recursion(ancestors, root.left);
        recursion(ancestors, root.right);
        ancestors.removeLast();
    }

    public static void main(String[] args) {
        Integer[] array = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeUtils.arrayToTree(array);
        TreeNode p = new TreeNode();
        p.val = 5;
        TreeNode q = new TreeNode();
        q.val = 4;
        System.out.println(new LowestCommonAncestorOffer68().lowestCommonAncestor(root, p, q));
    }
}
