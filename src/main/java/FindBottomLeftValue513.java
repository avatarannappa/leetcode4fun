import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/1
 */
public class FindBottomLeftValue513 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode result = root;
        while (!queue.isEmpty()) {
            List<TreeNode> levelList = new LinkedList<>(queue);
            queue.clear();
            boolean first = true;
            for (TreeNode node : levelList) {
                if (node.left != null) {
                    queue.add(node.left);
                    if (first) {
                        result = node.left;
                        first = false;
                    }
                }
                if (node.right != null) {
                    queue.add(node.right);
                    if (first) {
                        result = node.right;
                        first = false;
                    }
                }
            }
        }
        return result.val;
    }

    public static void main(String[] args) {
        Integer[] ints = {1, null, 1};
        TreeNode treeNode = TreeUtils.arrayToTree(ints);
        System.out.println(new FindBottomLeftValue513().findBottomLeftValue(treeNode));
    }

}
