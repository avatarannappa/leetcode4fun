import org.apache.commons.lang.ArrayUtils;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/13
 */
public class SortedArrayToBST108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length);
    }

    public TreeNode recursion(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursion(nums, start, mid);
        root.right = recursion(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBST108 sortedArrayToBST108 = new SortedArrayToBST108();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode t = sortedArrayToBST108.sortedArrayToBST(nums);
        System.out.println(t);
    }
}
