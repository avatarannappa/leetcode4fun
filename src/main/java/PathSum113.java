import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/24
 */
public class PathSum113 {
    List<List<Integer>> result = new ArrayList<>();
    int sum;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        this.sum = sum;
        recursion(new LinkedList<>(), root, 0);
        return result;
    }

    public void recursion(List<Integer> list, TreeNode root, int total) {
        if (root.left == null && root.right == null) {
            if (sum == total + root.val) {
                list.add(root.val);
                result.add(list);
            }
            return;
        }
        list.add(root.val);
        total += root.val;
        if (root.left != null) {
            List<Integer> left = new LinkedList<>();
            left.addAll(list);
            recursion(left, root.left, total);
        }
        if (root.right != null) {
            List<Integer> right = new LinkedList<>();
            right.addAll(list);
            recursion(right, root.right, total);
        }
    }

}
