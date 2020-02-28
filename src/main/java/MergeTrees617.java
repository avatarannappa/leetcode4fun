/**
 * 617. 合并二叉树.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/29
 */
public class MergeTrees617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            t1.val = t1.val + t2.val;
        }
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeUtils.arrayToTree(new Integer[]{1, 3, 2, 5});
        TreeNode t2 = TreeUtils.arrayToTree(new Integer[]{2, 1, 3, null, 4, null, 7});
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(new MergeTrees617().mergeTrees(t1, t2));
    }


}
