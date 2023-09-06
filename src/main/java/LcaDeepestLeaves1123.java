/**
 * 1123. 最深叶节点的最近公共祖先
 * medium
 *
 * @author avatarannappa
 * @date 2023/9/6
 */
public class LcaDeepestLeaves1123 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // 递归，同 865
        Tuple t = dfs(root);
        return t.node;
    }

    public static class Tuple {

        public TreeNode node;
        public int depth;
    }

    public Tuple dfs(TreeNode root) {
        Tuple tuple = new Tuple();

        if (root == null) {
            return tuple;
        }
        Tuple l = dfs(root.left);
        Tuple r = dfs(root.right);
        if (l.node == null && r.node == null) {
            tuple.node = root;
            tuple.depth = 1;
            return tuple;
        } else if (l.node == null) {
            r.depth += 1;
            return r;
        } else if (r.node == null) {
            l.depth += 1;
            return l;
        } else {
            if (l.depth > r.depth) {
                l.depth += 1;
                return l;
            } else if (l.depth < r.depth) {
                r.depth += 1;
                return r;
            } else {
                tuple.node = root;
                tuple.depth = l.depth + 1;
                return tuple;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeUtils.arrayToTree(arr);
        // 2, 7 ,4
        System.out.println(new LcaDeepestLeaves1123().lcaDeepestLeaves(root));
    }
}
