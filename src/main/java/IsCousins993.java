import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 993. 二叉树的堂兄弟节点
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2024/2/8
 */
public class IsCousins993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new LinkedList<>();
            boolean sign = false;
            while (!queue.isEmpty()) {
                TreeNode node = queue.pollFirst();
                boolean inSign = false;
                if (node.left != null) {
                    temp.add(node.left);
                    if (node.left.val == x || node.left.val == y) {
                        if (sign == true) {
                            return true;
                        } else {
                            sign = true;
                            inSign = true;
                        }
                    }
                }
                if (node.right != null) {
                    temp.add(node.right);
                    if (node.right.val == x || node.right.val == y) {
                        if(inSign) {
                            return false;
                        } else if (sign) {
                            return true;
                        } else {
                            sign = true;
                        }
                    }
                }
            }
            if (sign) {
                return false;
            }
            queue.addAll(temp);
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] nums = { 1, 2, 3, null, 4, null, 5 };
        TreeNode root = TreeUtils.arrayToTree(nums);
        int x = 4;
        int y = 5;
        System.out.println(new IsCousins993().isCousins(root, x, y));
    }
}
