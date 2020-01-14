import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树.
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/12
 */
public class RecoverTree99 {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        middle(root, list);
        TreeNode pre = null;
        TreeNode a = null;
        TreeNode b = null;
        boolean first = true;
        for (TreeNode node : list) {
            if (node == null) {
                continue;
            }
            if (pre == null) {
                pre = node;
                continue;
            }

            if (node.val < pre.val) {
                if (first) {
                    a = pre;
                    b = node;
                    first = false;
                } else {
                    b = node;
                }
            }
            pre = node;
        }
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public void middle(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        middle(node.left, list);
        list.add(node);
        middle(node.right, list);
    }
}
