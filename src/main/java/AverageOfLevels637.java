import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/12
 */
public class AverageOfLevels637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            double sum = 0;
            double size = queue.size();
            List<TreeNode> nextLevel = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            result.add(sum / size);
            queue.addAll(nextLevel);
        }

        return result;
    }

}
