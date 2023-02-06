/**
 * 2331. 计算布尔二叉树的值
 * easy
 *
 * @author avatarannappa
 * @date 2023/2/6
 */
public class EvaluateTree2331 {

    public boolean evaluateTree(TreeNode root) {
        // 经典递归
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}
