/**
 * 865. 具有所有最深节点的最小子树
 * medium
 *
 * @author avatarannappa
 * @date 2023/9/6
 */
public class SubTreeWithAllDeepest865 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // 递归，同 1123
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
}
