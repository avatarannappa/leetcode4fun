import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/2
 */
public class LevelOrderOffer32II {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> tempList = new ArrayList<>();
            List<Integer> level = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    tempList.add(node.left);
                }
                if (node.right != null) {
                    tempList.add(node.right);
                }
            }
            queue.addAll(tempList);
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeUtils.arrayToTree(array);
        System.out.println(new LevelOrderOffer32II().levelOrder(root));
    }

}
