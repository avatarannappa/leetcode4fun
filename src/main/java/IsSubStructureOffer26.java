/**
 * 剑指 Offer 26. 树的子结构
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/31
 */
public class IsSubStructureOffer26 {

    public TreeNode GB;
    public boolean sign = false;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        this.GB = B;
        return recursion(A, B);
    }

    private boolean recursion(TreeNode A, TreeNode B) {
        if (sign) {
            return true;
        }
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            return (recursion(A.left, B.left) && recursion(A.right, B.right));
        } else {
            B = GB;
            sign = recursion(A.left, B) || recursion(A.right, B);
            return sign;
        }
    }

    public static void main(String[] args) {
        Integer[] aa = {4, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] bb = {4, 8, 9};
        TreeNode A = TreeUtils.arrayToTree(aa);
        TreeNode B = TreeUtils.arrayToTree(bb);
        System.out.println(new IsSubStructureOffer26().isSubStructure(A, B));
    }
}
