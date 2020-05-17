import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍III.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/16
 */
public class Rob337 {

    Map<TreeNode, Integer> cache = new HashMap<>();

    public int rob(TreeNode root) {
        int[] result = robInterval(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInterval(TreeNode root) {
        // 0ms 100%
        if (root == null) {
            return new int[2];
        }
        int[] l = robInterval(root.left);
        int[] r = robInterval(root.right);

        int[] n = new int[2];
        n[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        n[1] = root.val + l[0] + r[0];
        return n;
    }

    public int robRemember(TreeNode root) {
        // 3 ms
        if (root == null) {
            return 0;
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += robRemember(root.left.left) + robRemember(root.left.right);
        }
        if (root.right != null) {
            money += robRemember(root.right.left) + robRemember(root.right.right);
        }
        Integer max = Math.max(money, robRemember(root.left) + robRemember(root.right));
        cache.put(root, max);
        return max;
    }

    public int robOld(TreeNode root) {
        // 960ms
        if (root == null) {
            return 0;
        }
        int money = root.val;
        if (root.left != null) {
            money += robOld(root.left.left) + robOld(root.left.right);
        }
        if (root.right != null) {
            money += robOld(root.right.left) + robOld(root.right.right);
        }
        return Math.max(money, robOld(root.left) + robOld(root.right));
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 2, 3, null, 3, null, 1};
        TreeNode root = TreeUtils.arrayToTree(nums);
        System.out.println(root);
        System.out.println(new Rob337().rob(root));
    }
}
