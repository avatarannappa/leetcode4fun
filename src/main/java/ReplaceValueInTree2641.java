import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 2641.二叉树的堂兄弟节点 II
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2024/2/7
 */
public class ReplaceValueInTree2641 {
    public TreeNode replaceValueInTree(TreeNode root) {
        // BFS+求和
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        root.val = 0;
        while (!queue.isEmpty()) {
            Queue<TreeNode> queue2 = new ArrayDeque<TreeNode>();
            int sum = 0;
            for (TreeNode fa : queue) {
                if (fa.left != null) {
                    queue2.offer(fa.left);
                    sum += fa.left.val;
                }
                if (fa.right != null) {
                    queue2.offer(fa.right);
                    sum += fa.right.val;
                }
            }
            for (TreeNode fa : queue) {
                int childSum = (fa.left != null ? fa.left.val : 0) + 
                                (fa.right != null ? fa.right.val : 0);
                if (fa.left != null) {
                    fa.left.val = sum - childSum;
                }
                if (fa.right != null) {
                    fa.right.val = sum - childSum;
                }
            }
            queue = queue2;
        }
        return root;
    }
}
