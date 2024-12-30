/**
 * 1367. 二叉树中的链表.
 * medium
 *
 * @author avatarannappa
 * @version 2024/12/30
 */
public class IsSubPath1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        // 递归嵌套
        return dfsHead(head, root);
    }

    private boolean dfsHead(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.val == head.val) {
            if (dfs(head, root)) {
                return true;
            }
        }
        return dfsHead(head, root.left) || dfsHead(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val == head.val) {
            return dfs(head.next, root.left) || dfs(head.next, root.right);
        }
        return false;
    }

}
