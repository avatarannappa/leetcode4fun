/**
 * 450. 删除二叉搜索树中的节点
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/23
 */
public class DeleteNode450 {

    public TreeNode pre(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public TreeNode post(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right != null) {
                TreeNode node = post(root);
                root.val = node.val;
                root.right = deleteNode(root.right, node.val);
            } else if (root.left != null) {
                TreeNode node = pre(root);
                root.val = node.val;
                root.left = deleteNode(root.left, node.val);
            } else {
                root = null;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] array = {50, 30, 70, null, 40, 60, 80};
        // [5,4,6,2,null,null,7]
        // [5,2,6,null,4,null,7]
        TreeNode root = TreeUtils.arrayToTree(array);
        System.out.println(new DeleteNode450().deleteNode(root, 80));
    }

}
