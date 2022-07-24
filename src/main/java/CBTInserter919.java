import java.util.Deque;
import java.util.LinkedList;

/**
 * 919. 完全二叉树插入器
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/7/25
 */
public class CBTInserter919 {

    TreeNode root;

    public CBTInserter919(TreeNode root) {
        this.root = root;
    }

    public int insert(int val) {
        // 层序遍历
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Deque<TreeNode> pre = new LinkedList<>();
        int level = 0;
        while (!queue.isEmpty()) {
            Deque<TreeNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (temp.left == null) {
                    TreeNode node = new TreeNode();
                    node.val = val;
                    temp.left = node;
                    return temp.val;
                }
                if (temp.right == null) {
                    TreeNode node = new TreeNode();
                    node.val = val;
                    temp.right = node;
                    return temp.val;
                }
                tempQueue.add(temp.left);
                tempQueue.add(temp.right);
            }
            queue.addAll(tempQueue);
        }
        return -1;
    }

    public TreeNode get_root() {
        return root;
    }

}
