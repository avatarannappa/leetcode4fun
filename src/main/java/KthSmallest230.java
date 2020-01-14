import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 *
 * @author avatarannappa
 * @version 1.0, 2019/6/13
 */
public class KthSmallest230 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode3;
        System.out.println(kthSmallest(treeNode, 1));
    }

    public static int kthSmallest(TreeNode root, int k) {
        int result = 0;
        List<Integer> list = traversal(root);
        result = list.get(k - 1);
        return result;
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
