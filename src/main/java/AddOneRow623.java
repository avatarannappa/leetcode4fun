import java.util.Deque;
import java.util.LinkedList;

/**
 * 623. 在二叉树中增加一行
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/5
 */
public class AddOneRow623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            Deque<TreeNode> tempQueue = new LinkedList<>();
            while ((!queue.isEmpty())) {
                TreeNode node = queue.poll();
                if (depth == level + 1) {
                    TreeNode l = new TreeNode(val);
                    TreeNode r = new TreeNode(val);
                    l.left = node.left;
                    r.right = node.right;
                    node.left = l;
                    node.right = r;
                    continue;
                }
                if (node.left != null) {
                    tempQueue.offer(node.left);
                }
                if (node.right != null) {
                    tempQueue.offer(node.right);
                }
            }
            level++;
            queue.addAll(tempQueue);
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 2, null, 3, 1};
        TreeNode root = TreeUtils.arrayToTree(arr);
        int val = 1;
        int depth = 3;
        System.out.println(new AddOneRow623().addOneRow(root, val, depth));
    }
}
