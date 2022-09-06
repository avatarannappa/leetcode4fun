import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 652. 寻找重复的子树
 * medium
 *
 * @author avatarannappa
 * @date 2022/9/5
 */
public class FindDuplicateSubtrees652 {

    Map<String, TreeNode> map = new HashMap<>();
    Set<String> set = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);

        List<TreeNode> ans = new ArrayList<>();
        for (String s : set) {
            ans.add(map.get(s));
        }
        return ans;
    }

    private String dfs(TreeNode root) {
        // 前、中、后序遍历都可以
        if (root == null) {
            return "";
        }
        String str = "";
        str += dfs(root.left);
        str += "#";
        str += dfs(root.right);
        str += "#";
        str += String.valueOf(root.val);
        str += "#";
        if (map.containsKey(str)) {
            set.add(str);
        }
        map.put(str, root);
        return str;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, null, 2, 4, null, null, 4};
        TreeNode root = TreeUtils.arrayToTree(arr);
        System.out.println(new FindDuplicateSubtrees652().findDuplicateSubtrees(root));
    }
}
