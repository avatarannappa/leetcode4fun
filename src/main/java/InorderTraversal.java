import java.util.ArrayList;
import java.util.List;

/**
 * 94.二叉树的中序遍历.
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 * <p>
 * 中序遍历：左子树---> 根结点 ---> 右子树
 * <p>
 * 后序遍历：左子树 ---> 右子树 ---> 根结点
 * <p>
 * 层次遍历：仅仅需按层次遍历就可以
 * <p>
 *
 * @author avatarannappa
 * @version 1.0, 2019/6/12
 */
public class InorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return result;
    }

    public static List<Integer> traversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.addAll(traversal(root.left));
        result.add(root.val);
        result.addAll(traversal(root.right));
        return result;
    }
}
