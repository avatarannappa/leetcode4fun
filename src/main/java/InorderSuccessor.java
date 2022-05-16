import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.06. 后继者.
 * meidum
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/5/16
 */
public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // BST特性
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }

    List<Integer> l = new ArrayList<>();

    public TreeNode inorderSuccessorOld(TreeNode root, TreeNode p) {
        // 中序遍历
        if (root == null) {
            return null;
        }
        inorder(root);
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).equals(p.val)) {
                return i == l.size() - 1 ? null : new TreeNode(l.get(i + 1));
            }
        }
        return null;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        l.add(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 6, 2, 4, null, null, 1};
        TreeNode root = TreeUtils.arrayToTree(arr);
        TreeNode p = new TreeNode(3);
        // 4
        System.out.println(new InorderSuccessor().inorderSuccessor(root, p));
    }
}
