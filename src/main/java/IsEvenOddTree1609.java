import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1609. 奇偶树.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/25
 */
public class IsEvenOddTree1609 {

    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean even = true;
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new LinkedList<>();

            if (even) {
                int pre = 0;
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();

                    if (node.val % 2 == 0 || node.val <= pre) {
                        return false;
                    }
                    pre = node.val;

                    if (node.left != null) {
                        temp.add(node.left);
                    }
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                }
                even =false;
            } else {
                int pre = Integer.MAX_VALUE;
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();

                    if (node.val % 2 == 1 || node.val >= pre) {
                        return false;
                    }
                    pre = node.val;

                    if (node.left != null) {
                        temp.add(node.left);
                    }
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                }
                even = true;
            }
            queue.addAll(temp);
        }
        return true;
    }

}
