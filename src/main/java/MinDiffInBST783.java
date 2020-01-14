import java.util.ArrayList;
import java.util.List;

/**
 * 783. 二叉搜索树结点最小距离
 * <p>
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 * <p>
 * 注意：
 * <p>
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 *
 * @author avatarannappa
 * @version 1.0, 2019/6/13
 */
public class MinDiffInBST783 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        System.out.println(minDiffInBST(root));
    }

    public static int minDiffInBST(TreeNode root) {
        List<Integer> list = traversal(root);
        int min = list.get(1) - list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) < min) {
                min = list.get(i) - list.get(i - 1);
            }
        }
        return min;
    }

    public static List<Integer> traversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.addAll(traversal(root.left));
        result.add(root.val);
        result.addAll(traversal(root.right));
        return result;
    }
}
