import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/3
 */
public class LargestValues515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.add(root.val);
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>(queue);
            queue.clear();
            int max = Integer.MIN_VALUE;
            for (TreeNode node : list) {
                if (node.left != null) {
                    queue.add(node.left);
                    max = Math.max(max, node.left.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    max = Math.max(max, node.right.val);
                }
            }
            if (max > Integer.MIN_VALUE) {
                result.add(max);
            }
        }
        return result;
    }

}
