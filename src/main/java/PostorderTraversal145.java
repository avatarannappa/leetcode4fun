import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历.
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/10
 */
public class PostorderTraversal145 {

    public List<Integer> postorderTraversal1(TreeNode root) {
        // 迭代法
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // 递归
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    public void recursion(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        recursion(node.left, list);
        recursion(node.right, list);
        list.add(node.val);
    }

}
