import java.util.Arrays;

/**
 * 21. 合并两个有序链表
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/23
 */
public class BuildTree105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if ((preorder == null || preorder.length <= 0) || (inorder == null || inorder.length <= 0)) {
            return null;
        }

        int root = 0;
        int preIndex = 0;
        int inIndex = 0;
        boolean sign = false;
        for (int i = 0; i < preorder.length; i++) {
            for (int j = 0; j < inorder.length; j++) {
                if (preorder[i] == inorder[j]) {
                    root = preorder[i];
                    sign = true;
                    preIndex = i;
                    inIndex = j;
                    break;
                }
            }
            if (sign) {
                break;
            }
        }

        TreeNode node = new TreeNode(root);
        node.left = buildTree(Arrays.copyOfRange(preorder, preIndex + 1, preorder.length),
                              Arrays.copyOfRange(inorder, 0, inIndex));
        node.right = buildTree(Arrays.copyOfRange(preorder, preIndex, preorder.length),
                               Arrays.copyOfRange(inorder, inIndex + 1, inorder.length));
        return node;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if ((preorder == null || preorder.length <= 0) || (inorder == null || inorder.length <= 0)) {
            return null;
        }

        int inIndex = 0;
        for (int j = 0; j < inorder.length; j++) {
            if (preorder[0] == inorder[j]) {
                inIndex = j;
                break;
            }
        }

        TreeNode node = new TreeNode(preorder[0]);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, inIndex + 1), Arrays.copyOfRange(inorder, 0, inIndex));
        node.right = buildTree(Arrays.copyOfRange(preorder, inIndex + 1, preorder.length),
                               Arrays.copyOfRange(inorder, inIndex + 1, inorder.length));
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(new BuildTree105().buildTree2(preorder, inorder));
    }

}
