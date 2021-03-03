/**
 * 606. 根据二叉树创建字符串
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/3
 */
public class Tree2str606 {

    String result = "";

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        recursion(t);
        return result;
    }

    public void recursion(TreeNode t) {
        if (t == null) {
            return;
        }
        result += t.val;
        if (t.left != null) {
            result += "(";
            recursion(t.left);
            result += ")";
        }

        if (t.right != null) {
            if (t.left == null) {
                result += "(";
                result += ")";
            }
            result += "(";
            recursion(t.right);
            result += ")";
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4};
        TreeNode tree = TreeUtils.arrayToTree(a);
        // 1(2(4)())(3()) -> 1(2(4))(3)
        System.out.println(new Tree2str606().tree2str(tree));
    }
}
