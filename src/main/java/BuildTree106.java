import java.util.Arrays;

/**
 * 106. 从中序与后序遍历序列构造二叉树.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/5
 */
public class BuildTree106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if ((postorder == null || postorder.length <= 0) || (inorder == null || inorder.length != postorder.length)) {
            return null;
        }

        int inIndex = 0;
        for (int j = 0; j < inorder.length; j++) {
            if (postorder[postorder.length - 1] == inorder[j]) {
                inIndex = j;
                break;
            }
        }

        TreeNode node = new TreeNode(postorder[postorder.length - 1]);
        node.left = buildTree(Arrays.copyOfRange(inorder, 0, inIndex), Arrays.copyOfRange(postorder, 0, inIndex));
        node.right = buildTree(Arrays.copyOfRange(inorder, inIndex + 1, inorder.length),
                               Arrays.copyOfRange(postorder, inIndex, postorder.length - 1));
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        System.out.println(new BuildTree106().buildTree(inorder, postorder));
    }
}
